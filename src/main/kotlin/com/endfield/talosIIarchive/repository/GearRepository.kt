package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.Gear
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GearRepository : JpaRepository<Gear, Long> {
    fun findByGearTypeId(gearTypeId: Long): List<Gear>
    fun findByGearSetId(gearSetId: Long): List<Gear>
    fun findByNameContainingIgnoreCase(name: String): List<Gear>
    fun findByGearTypeIdAndGearSetId(gearTypeId: Long, gearSetId: Long): List<Gear>
}