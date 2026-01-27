package com.endfield.talosIIarchive.controller.dto

import com.endfield.talosIIarchive.model.Weapon

data class WeaponSummaryDTO(
    val id: Long,
    val name: String,
    val rarity: String,
    val imageUrl: String?,
    val weaponType: String,
    val baseAtk: Int
)

data class WeaponDetailDTO(
    val id: Long,
    val name: String,
    val rarity: String,
    val imageUrl: String?,
    val weaponType: String,
    val baseAtk: Int,
    val stat1: String?,
    val stat2: String?,
    val passive: String
)

fun Weapon.toSummaryDTO() = WeaponSummaryDTO(
    id = this.id,
    name = this.name,
    rarity = "${this.rarity.stars}★",
    imageUrl = this.imageUrl,
    weaponType = this.weaponType.name,
    baseAtk = this.baseAtk
)

fun Weapon.toDetailDTO() = WeaponDetailDTO(
    id = this.id,
    name = this.name,
    rarity = "${this.rarity.stars}★",
    imageUrl = this.imageUrl,
    weaponType = this.weaponType.name,
    baseAtk = this.baseAtk,
    stat1 = this.stat1,
    stat2 = this.stat2,
    passive = this.passive
)