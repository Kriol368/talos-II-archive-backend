package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.Operator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OperatorRepository : JpaRepository<Operator, Long>