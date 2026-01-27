package com.endfield.talosIIarchive.model

import jakarta.persistence.*

@Entity
@Table(name = "weapon_type")
data class WeaponType(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,

    @Column(nullable = false, unique = true, length = 50) val name: String
)