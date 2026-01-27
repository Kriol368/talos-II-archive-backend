package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamRepository : JpaRepository<Team, Long> {
    fun findAllByOrderByCreatedAtDesc(): List<Team>
}