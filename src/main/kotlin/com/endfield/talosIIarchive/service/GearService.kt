package com.endfield.talosIIarchive.service

import com.endfield.talosIIarchive.model.Gear
import com.endfield.talosIIarchive.repository.GearRepository
import org.springframework.stereotype.Service

@Service
class GearService(
    private val gearRepository: GearRepository
) {

    fun getAllGear(): List<Gear> {
        return gearRepository.findAll()
    }

    fun getGearById(id: Long): Gear? {
        return gearRepository.findById(id).orElse(null)
    }
}