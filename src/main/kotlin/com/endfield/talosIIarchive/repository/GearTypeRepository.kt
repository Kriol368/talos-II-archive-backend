package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.GearType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GearTypeRepository : JpaRepository<GearType, Long> {
    fun findByName(name: String): GearType?
}