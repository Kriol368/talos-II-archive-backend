package com.endfield.talosIIarchive.model

import jakarta.persistence.*

@Entity
@Table(name = "gear")
data class Gear(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,

    @Column(nullable = false, length = 100) val name: String,

    @Column(name = "image_url", length = 500) val imageUrl: String? = null,

    @ManyToOne @JoinColumn(name = "gear_type_id", nullable = false) val gearType: GearType,

    @ManyToOne @JoinColumn(name = "gear_set_id", nullable = false) val gearSet: GearSet,

    @Column(name = "attribute_1", length = 100) val attribute1: String? = null,

    @Column(name = "attribute_2", length = 100) val attribute2: String? = null,

    @Column(name = "attribute_3", length = 100) val attribute3: String? = null,

    @Column(nullable = false) val def: Int
)