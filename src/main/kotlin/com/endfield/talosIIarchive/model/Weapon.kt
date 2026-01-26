package com.endfield.talosIIarchive.model

import jakarta.persistence.*

@Entity
@Table(name = "weapon")
data class Weapon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true, length = 100)
    val name: String,

    @ManyToOne
    @JoinColumn(name = "rarity_id", nullable = false)
    val rarity: Rarity,

    @Column(name = "image_url", length = 500)
    val imageUrl: String? = null,

    @ManyToOne
    @JoinColumn(name = "weapon_type_id", nullable = false)
    val weaponType: WeaponType,

    @Column(name = "base_atk", nullable = false)
    val baseAtk: Int,

    @Column(name = "stat_1", length = 100)
    val stat1: String? = null,

    @Column(name = "stat_2", length = 100)
    val stat2: String? = null,

    @Column(nullable = false, columnDefinition = "TEXT")
    val passive: String
)