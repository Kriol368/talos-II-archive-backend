package com.endfield.talosIIarchive.model

import jakarta.persistence.*

@Entity
@Table(name = "gear_type")
data class GearType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true, length = 20)
    val name: String
)