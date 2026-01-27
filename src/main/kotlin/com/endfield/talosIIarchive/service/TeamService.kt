package com.endfield.talosIIarchive.service

import com.endfield.talosIIarchive.model.*
import com.endfield.talosIIarchive.repository.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TeamService(
    private val teamRepository: TeamRepository,
    private val teamOperatorRepository: TeamOperatorRepository,
    private val teamOperatorEquipmentRepository: TeamOperatorEquipmentRepository,
    private val operatorRepository: OperatorRepository,
    private val weaponRepository: WeaponRepository,
    private val gearRepository: GearRepository
) {

    fun getAllTeams(): List<Team> {
        return teamRepository.findAllByOrderByCreatedAtDesc()
    }

    fun getTeamById(id: Long): Team? {
        return teamRepository.findById(id).orElse(null)
    }

    fun getTeamOperators(teamId: Long): List<TeamOperator> {
        return teamOperatorRepository.findByTeamId(teamId)
    }

    fun getTeamEquipment(teamId: Long): List<TeamOperatorEquipment> {
        return teamOperatorEquipmentRepository.findByTeamId(teamId)
    }

    @Transactional
    fun createTeam(
        teamName: String,
        description: String?,
        operators: List<Operator>,
        weapons: List<Weapon>,
        gearSets: List<List<Gear>>
    ): Team {
        require(operators.size == 4) { "Team must have exactly 4 operators" }
        require(weapons.size == 4) { "Team must have exactly 4 weapons" }
        require(gearSets.size == 4) { "Team must have gear for 4 operators" }

        val operatorIds = operators.map { it.id }
        require(operatorIds.distinct().size == 4) { "Cannot have duplicate operators in a team" }

        val team = Team(
            teamName = teamName,
            description = description
        )
        val savedTeam = teamRepository.save(team)

        for ((index, operator) in operators.withIndex()) {
            val teamOperator = TeamOperator(
                team = savedTeam,
                operator = operator,
                position = index
            )
            teamOperatorRepository.save(teamOperator)
        }

        for ((index, operator) in operators.withIndex()) {
            val weapon = weapons[index]
            val gearList = gearSets[index]

            require(operator.weaponType.id == weapon.weaponType.id) {
                "Operator ${operator.name} cannot use weapon ${weapon.name}"
            }

            require(gearList.size == 4) { "Each operator must have exactly 4 gear pieces" }

            val armor = gearList[0]
            val gloves = gearList[1]
            val kit1 = gearList[2]
            val kit2 = gearList[3]

            require(armor.gearType.name == "Armor") { "First gear must be Armor type" }
            require(gloves.gearType.name == "Gloves") { "Second gear must be Gloves type" }
            require(kit1.gearType.name == "Kit") { "Third gear must be Kit type" }
            require(kit2.gearType.name == "Kit") { "Fourth gear must be Kit type" }
            require(kit1.id != kit2.id) { "Kits must be different pieces" }

            val equipment = TeamOperatorEquipment(
                team = savedTeam,
                operatorPosition = index,
                weapon = weapon,
                armorGear = armor,
                glovesGear = gloves,
                kit1Gear = kit1,
                kit2Gear = kit2
            )
            teamOperatorEquipmentRepository.save(equipment)
        }

        return savedTeam
    }

    fun calculateSetBonuses(teamId: Long): Map<Int, List<GearSet>> {
        val equipmentList = teamOperatorEquipmentRepository.findByTeamId(teamId)
        val bonuses = mutableMapOf<Int, List<GearSet>>()

        for (equipment in equipmentList) {
            val operatorPosition = equipment.operatorPosition
            val gearPieces = listOf(
                equipment.armorGear,
                equipment.glovesGear,
                equipment.kit1Gear,
                equipment.kit2Gear
            )

            val setCounts = gearPieces.groupingBy { it.gearSet }.eachCount()

            val activeSets = setCounts.filter { it.value >= 3 }.keys.toList()

            if (activeSets.isNotEmpty()) {
                bonuses[operatorPosition] = activeSets
            }
        }

        return bonuses
    }

}