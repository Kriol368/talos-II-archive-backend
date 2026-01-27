package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.WeaponType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WeaponTypeRepository : JpaRepository<WeaponType, Long> {
    fun findByName(name: String): WeaponType?
}