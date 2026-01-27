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

    fun getGearByType(gearTypeId: Long): List<Gear> {
        return gearRepository.findByGearTypeId(gearTypeId)
    }

    fun getGearBySet(gearSetId: Long): List<Gear> {
        return gearRepository.findByGearSetId(gearSetId)
    }

    fun getGearByTypeAndSet(gearTypeId: Long, gearSetId: Long): List<Gear> {
        return gearRepository.findByGearTypeIdAndGearSetId(gearTypeId, gearSetId)
    }

    fun searchGearByName(name: String): List<Gear> {
        return gearRepository.findByNameContainingIgnoreCase(name)
    }

    fun saveGear(gear: Gear): Gear {
        return gearRepository.save(gear)
    }

    fun deleteGear(id: Long) {
        gearRepository.deleteById(id)
    }
}