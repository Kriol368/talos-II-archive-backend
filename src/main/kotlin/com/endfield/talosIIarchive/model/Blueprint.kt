package com.endfield.talosIIarchive.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "blueprint")
data class Blueprint(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,

    @Column(nullable = false, length = 100) val title: String,

    @Column(columnDefinition = "TEXT") val description: String? = null,

    @Column(name = "code_hash", nullable = false, length = 500) val codeHash: String,

    @Column(name = "created_at", nullable = false) val createdAt: LocalDateTime = LocalDateTime.now()
)