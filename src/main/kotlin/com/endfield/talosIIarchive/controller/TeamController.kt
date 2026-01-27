package com.endfield.talosIIarchive.controller

import com.endfield.talosIIarchive.controller.dto.*
import com.endfield.talosIIarchive.service.TeamService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/endfield/teams")
class TeamController(
    private val teamService: TeamService,
    private val operatorService: com.endfield.talosIIarchive.service.OperatorService,
    private val weaponService: com.endfield.talosIIarchive.service.WeaponService,
    private val gearService: com.endfield.talosIIarchive.service.GearService
) {

    @GetMapping
    fun getAllTeams(): List<TeamSummaryDTO> {
        return teamService.getAllTeams().map { team ->
            val operators = teamService.getTeamOperators(team.id)
            val operatorNames = operators.sortedBy { it.position }.map { it.operator.name }
            team.toSummaryDTO(operatorNames)
        }
    }

    @GetMapping("/{id}")
    fun getTeamById(@PathVariable id: Long): ResponseEntity<TeamDetailDTO> {
        val team = teamService.getTeamById(id) ?: return ResponseEntity.notFound().build()

        val teamOperators = teamService.getTeamOperators(id).sortedBy { it.position }

        val equipmentList = teamService.getTeamEquipment(id)

        val operatorDTOs = mutableListOf<TeamOperatorEquipmentDTO>()

        for ((position, teamOperator) in teamOperators.withIndex()) {
            val equipment = equipmentList.find { it.operatorPosition == position }
            if (equipment != null) {
                val gearPieces = listOf(
                    equipment.armorGear, equipment.glovesGear, equipment.kit1Gear, equipment.kit2Gear
                )
                val setCounts = gearPieces.groupingBy { it.gearSet }.eachCount()
                val activeBonuses = setCounts.filter { it.value >= 3 }.keys.map { it.name }

                val operatorDTO = TeamOperatorEquipmentDTO(
                    operatorPosition = position,
                    operatorName = teamOperator.operator.name,
                    operatorImage = teamOperator.operator.imageUrl,
                    weaponName = equipment.weapon.name,
                    weaponImage = equipment.weapon.imageUrl,
                    armorGear = equipment.armorGear.toSummaryDTO(),
                    glovesGear = equipment.glovesGear.toSummaryDTO(),
                    kit1Gear = equipment.kit1Gear.toSummaryDTO(),
                    kit2Gear = equipment.kit2Gear.toSummaryDTO(),
                    activeSetBonuses = activeBonuses
                )
                operatorDTOs.add(operatorDTO)
            }
        }

        val setBonuses = teamService.calculateSetBonuses(id)
        val formattedBonuses = setBonuses.mapValues { (_, gearSets) ->
            gearSets.map { it.name }
        }

        val response = team.toDetailDTO(operatorDTOs, formattedBonuses)
        return ResponseEntity.ok(response)
    }


    @PostMapping
    fun createTeam(@RequestBody request: CreateTeamRequestDTO): ResponseEntity<Any> {
        try {
            val operators = request.operatorIds.mapNotNull { operatorService.getOperatorById(it) }
            if (operators.size != 4) {
                return ResponseEntity.badRequest().body("Need exactly 4 valid operators")
            }

            val weapons = request.weaponIds.mapNotNull { weaponService.getWeaponById(it) }
            if (weapons.size != 4) {
                return ResponseEntity.badRequest().body("Need exactly 4 valid weapons")
            }

            val gearSets = request.gearIds.map { gearList ->
                gearList.mapNotNull { gearService.getGearById(it) }
            }
            if (gearSets.size != 4 || gearSets.any { it.size != 4 }) {
                return ResponseEntity.badRequest().body("Need exactly 4 gear sets with 4 pieces each")
            }

            val team = teamService.createTeam(
                teamName = request.teamName,
                description = request.description,
                operators = operators,
                weapons = weapons,
                gearSets = gearSets
            )

            return ResponseEntity.status(HttpStatus.CREATED).body(team)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.badRequest().body(e.message)
        } catch (e: Exception) {
            return ResponseEntity.internalServerError().body("Error creating team: ${e.message}")
        }
    }
}