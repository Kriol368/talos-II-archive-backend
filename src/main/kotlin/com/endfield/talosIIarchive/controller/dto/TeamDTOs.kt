package com.endfield.talosIIarchive.controller.dto

import com.endfield.talosIIarchive.model.*
import java.time.format.DateTimeFormatter

data class TeamSummaryDTO(
    val id: Long,
    val teamName: String,
    val description: String?,
    val createdAt: String,
    val operatorNames: List<String>
)

data class TeamOperatorEquipmentDTO(
    val operatorPosition: Int,
    val operatorName: String,
    val operatorImage: String?,
    val weaponName: String,
    val weaponImage: String?,
    val armorGear: GearSummaryDTO,
    val glovesGear: GearSummaryDTO,
    val kit1Gear: GearSummaryDTO,
    val kit2Gear: GearSummaryDTO,
    val activeSetBonuses: List<String>
)

data class TeamDetailDTO(
    val id: Long,
    val teamName: String,
    val description: String?,
    val createdAt: String,
    val operators: List<TeamOperatorEquipmentDTO>,
    val totalSetBonuses: Map<Int, List<String>>
)

data class CreateTeamRequestDTO(
    val teamName: String,
    val description: String? = null,
    val operatorIds: List<Long>,
    val weaponIds: List<Long>,
    val gearIds: List<List<Long>>
)

private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

fun Team.toSummaryDTO(operatorNames: List<String>) = TeamSummaryDTO(
    id = this.id,
    teamName = this.teamName,
    description = this.description,
    createdAt = this.createdAt.format(dateFormatter),
    operatorNames = operatorNames
)

fun Team.toDetailDTO(
    operators: List<TeamOperatorEquipmentDTO>,
    setBonuses: Map<Int, List<String>>
) = TeamDetailDTO(
    id = this.id,
    teamName = this.teamName,
    description = this.description,
    createdAt = this.createdAt.format(dateFormatter),
    operators = operators,
    totalSetBonuses = setBonuses
)