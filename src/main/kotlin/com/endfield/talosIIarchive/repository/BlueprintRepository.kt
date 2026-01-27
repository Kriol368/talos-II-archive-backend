package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.Blueprint
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlueprintRepository : JpaRepository<Blueprint, Long> {
    fun findAllByOrderByCreatedAtDesc(): List<Blueprint>
}