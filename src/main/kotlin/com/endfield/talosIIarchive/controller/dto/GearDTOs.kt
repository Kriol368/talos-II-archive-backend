package com.endfield.talosIIarchive.controller.dto

import com.endfield.talosIIarchive.model.Gear

data class GearSummaryDTO(
    val id: Long,
    val name: String,
    val imageUrl: String?,
    val gearType: String,
    val gearSet: String,
    val def: Int
)

data class GearDetailDTO(
    val id: Long,
    val name: String,
    val imageUrl: String?,
    val gearType: String,
    val gearSet: String,
    val attribute1: String?,
    val attribute2: String?,
    val attribute3: String?,
    val def: Int,
    val setBonus: String?
)

fun Gear.toSummaryDTO() = GearSummaryDTO(
    id = this.id,
    name = this.name,
    imageUrl = this.imageUrl,
    gearType = this.gearType.name,
    gearSet = this.gearSet.name,
    def = this.def
)

fun Gear.toDetailDTO() = GearDetailDTO(
    id = this.id,
    name = this.name,
    imageUrl = this.imageUrl,
    gearType = this.gearType.name,
    gearSet = this.gearSet.name,
    attribute1 = this.attribute1,
    attribute2 = this.attribute2,
    attribute3 = this.attribute3,
    def = this.def,
    setBonus = this.gearSet.bonusDescription
)