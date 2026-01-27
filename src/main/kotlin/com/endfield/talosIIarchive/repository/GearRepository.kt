package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.Gear
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GearRepository : JpaRepository<Gear, Long>