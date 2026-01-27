package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.TeamOperatorEquipment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamOperatorEquipmentRepository : JpaRepository<TeamOperatorEquipment, Long> {
    fun findByTeamId(teamId: Long): List<TeamOperatorEquipment>
    fun findByTeamIdAndOperatorPosition(teamId: Long, operatorPosition: Int): TeamOperatorEquipment?
}