package com.endfield.talosIIarchive.service

import com.endfield.talosIIarchive.model.Weapon
import com.endfield.talosIIarchive.repository.WeaponRepository
import org.springframework.stereotype.Service

@Service
class WeaponService(
    private val weaponRepository: WeaponRepository
) {

    fun getAllWeapons(): List<Weapon> {
        return weaponRepository.findAll()
    }

    fun getWeaponById(id: Long): Weapon? {
        return weaponRepository.findById(id).orElse(null)
    }

    fun getWeaponsByType(weaponTypeId: Long): List<Weapon> {
        return weaponRepository.findByWeaponTypeId(weaponTypeId)
    }

    fun getWeaponsByRarity(rarityId: Long): List<Weapon> {
        return weaponRepository.findByRarityId(rarityId)
    }

    fun searchWeaponsByName(name: String): List<Weapon> {
        return weaponRepository.findByNameContainingIgnoreCase(name)
    }

    fun saveWeapon(weapon: Weapon): Weapon {
        return weaponRepository.save(weapon)
    }

    fun deleteWeapon(id: Long) {
        weaponRepository.deleteById(id)
    }
}