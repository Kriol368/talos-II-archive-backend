package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.Blueprint
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlueprintRepository : JpaRepository<Blueprint, Long> {
    fun findByTitleContainingIgnoreCase(title: String): List<Blueprint>
    fun findByCodeHash(codeHash: String): List<Blueprint>
    fun findAllByOrderByCreatedAtDesc(): List<Blueprint>
}