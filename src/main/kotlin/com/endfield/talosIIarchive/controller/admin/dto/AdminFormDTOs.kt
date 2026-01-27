package com.endfield.talosIIarchive.controller.admin.dto

data class OperatorFormDTO(
    var id: Long = 0,
    var name: String = "",
    var rarityId: Long? = null,
    var imageUrl: String? = null,
    var elementId: Long? = null,
    var weaponTypeId: Long? = null,
    var operatorClassId: Long? = null,
    var strength: Int = 0,
    var agility: Int = 0,
    var intellect: Int = 0,
    var will: Int = 0,
    var basicAttack: String = "",
    var basicAttackDescription: String = "",
    var battleSkill: String = "",
    var battleSkillDescription: String = "",
    var battleSkillSpCost: Int = 0,
    var comboSkill: String = "",
    var comboSkillDescription: String = "",
    var comboSkillCooldown: Int = 0,
    var ultimate: String = "",
    var ultimateDescription: String = "",
    var ultimateEnergyCost: Int = 0,
    var baseTalent1: String = "",
    var baseTalent2: String = "",
    var combatTalent1: String = "",
    var combatTalent2: String = "",
    var p1: String? = null,
    var p1Effect: String? = null,
    var p2: String? = null,
    var p2Effect: String? = null,
    var p3: String? = null,
    var p3Effect: String? = null,
    var p4: String? = null,
    var p4Effect: String? = null,
    var p5: String? = null,
    var p5Effect: String? = null,
    var conceptArt1: String? = null,
    var conceptArt2: String? = null,
    var conceptArt3: String? = null
)

data class WeaponFormDTO(
    var id: Long = 0,
    var name: String = "",
    var rarityId: Long? = null,
    var imageUrl: String? = null,
    var weaponTypeId: Long? = null,
    var baseAtk: Int = 0,
    var stat1: String? = null,
    var stat2: String? = null,
    var passive: String = ""
)

data class GearFormDTO(
    var id: Long = 0,
    var name: String = "",
    var imageUrl: String? = null,
    var gearTypeId: Long? = null,
    var gearSetId: Long? = null,
    var attribute1: String? = null,
    var attribute2: String? = null,
    var attribute3: String? = null,
    var def: Int = 0
)