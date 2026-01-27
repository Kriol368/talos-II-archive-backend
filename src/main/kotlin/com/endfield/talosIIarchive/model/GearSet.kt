package com.endfield.talosIIarchive.model

import jakarta.persistence.*

@Entity
@Table(name = "gear_set")
data class GearSet(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,

    @Column(nullable = false, unique = true, length = 100) val name: String,

    @Column(name = "bonus_description", columnDefinition = "TEXT") val bonusDescription: String? = null
)