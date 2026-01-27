package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.OperatorClass
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OperatorClassRepository : JpaRepository<OperatorClass, Long> {
    fun findByName(name: String): OperatorClass?
}