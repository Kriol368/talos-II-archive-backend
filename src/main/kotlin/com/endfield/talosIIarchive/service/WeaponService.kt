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
}