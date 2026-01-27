package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.Weapon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WeaponRepository : JpaRepository<Weapon, Long> {
    fun findByWeaponTypeId(weaponTypeId: Long): List<Weapon>
    fun findByRarityId(rarityId: Long): List<Weapon>
    fun findByNameContainingIgnoreCase(name: String): List<Weapon>
}