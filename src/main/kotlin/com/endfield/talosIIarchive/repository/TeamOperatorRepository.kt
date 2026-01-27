package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.TeamOperator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamOperatorRepository : JpaRepository<TeamOperator, Long> {
    fun findByTeamId(teamId: Long): List<TeamOperator>
}