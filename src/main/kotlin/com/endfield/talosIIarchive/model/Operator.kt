package com.endfield.talosIIarchive.model

import jakarta.persistence.*

@Entity
@Table(name = "operator")
data class Operator(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,

    @Column(nullable = false, unique = true, length = 100) val name: String,

    @ManyToOne @JoinColumn(name = "rarity_id", nullable = false) val rarity: Rarity,

    @Column(name = "image_url", length = 500) val imageUrl: String? = null,

    @ManyToOne @JoinColumn(name = "element_id", nullable = false) val element: Element,

    @ManyToOne @JoinColumn(name = "weapon_type_id", nullable = false) val weaponType: WeaponType,

    @ManyToOne @JoinColumn(name = "operator_class_id", nullable = false) val operatorClass: OperatorClass,

    @Column(nullable = false) val strength: Int,

    @Column(nullable = false) val agility: Int,

    @Column(nullable = false) val intellect: Int,

    @Column(nullable = false) val will: Int,

    @Column(name = "basic_attack", nullable = false, length = 100) val basicAttack: String,

    @Column(name = "basic_attack_desc", nullable = false, columnDefinition = "TEXT") val basicAttackDescription: String,

    @Column(name = "battle_skill", nullable = false, length = 100) val battleSkill: String,

    @Column(name = "battle_skill_desc", nullable = false, columnDefinition = "TEXT") val battleSkillDescription: String,

    @Column(name = "battle_skill_sp_cost", nullable = false) val battleSkillSpCost: Int,

    @Column(name = "combo_skill", nullable = false, length = 100) val comboSkill: String,

    @Column(name = "combo_skill_desc", nullable = false, columnDefinition = "TEXT") val comboSkillDescription: String,

    @Column(name = "combo_skill_cooldown", nullable = false) val comboSkillCooldown: Int,

    @Column(name = "ultimate", nullable = false, length = 100) val ultimate: String,

    @Column(name = "ultimate_desc", nullable = false, columnDefinition = "TEXT") val ultimateDescription: String,

    @Column(name = "ultimate_energy_cost", nullable = false) val ultimateEnergyCost: Int,

    @Column(name = "base_talent_1", nullable = false, columnDefinition = "TEXT") val baseTalent1: String,

    @Column(name = "base_talent_2", nullable = false, columnDefinition = "TEXT") val baseTalent2: String,

    @Column(name = "combat_talent_1", nullable = false, columnDefinition = "TEXT") val combatTalent1: String,

    @Column(name = "combat_talent_2", nullable = false, columnDefinition = "TEXT") val combatTalent2: String,

    @Column(name = "p1", columnDefinition = "TEXT") val p1: String? = null,

    @Column(name = "p1_effect", columnDefinition = "TEXT") val p1Effect: String? = null,

    @Column(name = "p2", columnDefinition = "TEXT") val p2: String? = null,

    @Column(name = "p2_effect", columnDefinition = "TEXT") val p2Effect: String? = null,

    @Column(name = "p3", columnDefinition = "TEXT") val p3: String? = null,

    @Column(name = "p3_effect", columnDefinition = "TEXT") val p3Effect: String? = null,

    @Column(name = "p4", columnDefinition = "TEXT") val p4: String? = null,

    @Column(name = "p4_effect", columnDefinition = "TEXT") val p4Effect: String? = null,

    @Column(name = "p5", columnDefinition = "TEXT") val p5: String? = null,

    @Column(name = "p5_effect", columnDefinition = "TEXT") val p5Effect: String? = null,

    @Column(name = "concept_art_1", length = 500) val conceptArt1: String? = null,

    @Column(name = "concept_art_2", length = 500) val conceptArt2: String? = null,

    @Column(name = "concept_art_3", length = 500) val conceptArt3: String? = null
)