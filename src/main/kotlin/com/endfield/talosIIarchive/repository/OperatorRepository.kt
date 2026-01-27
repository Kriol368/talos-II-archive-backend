package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.Operator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OperatorRepository : JpaRepository<Operator, Long> {
    fun findByWeaponTypeId(weaponTypeId: Long): List<Operator>
    fun findByElementId(elementId: Long): List<Operator>
    fun findByOperatorClassId(operatorClassId: Long): List<Operator>
    fun findByRarityId(rarityId: Long): List<Operator>
    fun findByNameContainingIgnoreCase(name: String): List<Operator>
}