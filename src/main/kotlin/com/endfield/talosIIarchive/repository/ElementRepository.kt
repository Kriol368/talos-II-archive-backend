package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.Element
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ElementRepository : JpaRepository<Element, Long> {
    fun findByName(name: String): Element?
}