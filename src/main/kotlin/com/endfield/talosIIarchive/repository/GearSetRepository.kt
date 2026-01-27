package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.GearSet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GearSetRepository : JpaRepository<GearSet, Long> {
    fun findByName(name: String): GearSet?
}