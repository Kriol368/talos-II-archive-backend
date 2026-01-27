package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.Weapon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WeaponRepository : JpaRepository<Weapon, Long>