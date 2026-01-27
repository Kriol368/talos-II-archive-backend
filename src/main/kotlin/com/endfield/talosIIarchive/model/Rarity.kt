package com.endfield.talosIIarchive.model

import jakarta.persistence.*

@Entity
@Table(name = "rarity")
data class Rarity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,

    @Column(nullable = false, unique = true) val stars: Int
)