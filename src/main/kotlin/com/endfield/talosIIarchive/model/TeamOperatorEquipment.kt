package com.endfield.talosIIarchive.model

import jakarta.persistence.*

@Entity
@Table(name = "team_operator_equipment")
data class TeamOperatorEquipment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    val team: Team,

    @Column(name = "operator_position", nullable = false)
    val operatorPosition: Int,

    @ManyToOne
    @JoinColumn(name = "weapon_id", nullable = false)
    val weapon: Weapon,

    @ManyToOne
    @JoinColumn(name = "armor_gear_id", nullable = false)
    val armorGear: Gear,

    @ManyToOne
    @JoinColumn(name = "gloves_gear_id", nullable = false)
    val glovesGear: Gear,

    @ManyToOne
    @JoinColumn(name = "kit1_gear_id", nullable = false)
    val kit1Gear: Gear,

    @ManyToOne
    @JoinColumn(name = "kit2_gear_id", nullable = false)
    val kit2Gear: Gear
)