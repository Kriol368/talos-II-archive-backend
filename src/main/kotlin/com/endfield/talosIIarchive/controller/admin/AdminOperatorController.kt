package com.endfield.talosIIarchive.controller.admin

import com.endfield.talosIIarchive.controller.admin.dto.OperatorFormDTO
import com.endfield.talosIIarchive.model.Operator
import com.endfield.talosIIarchive.service.OperatorService
import com.endfield.talosIIarchive.service.ReferenceDataService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/endfield/admin/operators")
class AdminOperatorController(
    private val operatorService: OperatorService,
    private val referenceDataService: ReferenceDataService
) {

    @GetMapping
    fun listOperators(model: Model): String {
        model.addAttribute("operators", operatorService.getAllOperators())
        return "admin/operators/list"
    }

    @GetMapping("/create")
    fun showCreateForm(model: Model): String {
        model.addAttribute("operatorForm", OperatorFormDTO())  // Usa DTO, no Entity
        model.addAttribute("rarities", referenceDataService.getAllRarities())
        model.addAttribute("elements", referenceDataService.getAllElements())
        model.addAttribute("weaponTypes", referenceDataService.getAllWeaponTypes())
        model.addAttribute("operatorClasses", referenceDataService.getAllOperatorClasses())
        return "admin/operators/create"
    }

    @PostMapping("/create")
    fun createOperator(@ModelAttribute operatorForm: OperatorFormDTO): String {
        val rarity = operatorForm.rarityId?.let { referenceDataService.getRarityById(it) }
        val element = operatorForm.elementId?.let { referenceDataService.getElementById(it) }
        val weaponType = operatorForm.weaponTypeId?.let { referenceDataService.getWeaponTypeById(it) }
        val operatorClass = operatorForm.operatorClassId?.let { referenceDataService.getOperatorClassById(it) }

        if (rarity != null && element != null && weaponType != null && operatorClass != null) {
            val operator = Operator(
                name = operatorForm.name,
                rarity = rarity,
                imageUrl = operatorForm.imageUrl,
                element = element,
                weaponType = weaponType,
                operatorClass = operatorClass,
                strength = operatorForm.strength,
                agility = operatorForm.agility,
                intellect = operatorForm.intellect,
                will = operatorForm.will,
                basicAttack = operatorForm.basicAttack,
                basicAttackDescription = operatorForm.basicAttackDescription,
                battleSkill = operatorForm.battleSkill,
                battleSkillDescription = operatorForm.battleSkillDescription,
                battleSkillSpCost = operatorForm.battleSkillSpCost,
                comboSkill = operatorForm.comboSkill,
                comboSkillDescription = operatorForm.comboSkillDescription,
                comboSkillCooldown = operatorForm.comboSkillCooldown,
                ultimate = operatorForm.ultimate,
                ultimateDescription = operatorForm.ultimateDescription,
                ultimateEnergyCost = operatorForm.ultimateEnergyCost,
                baseTalent1 = operatorForm.baseTalent1,
                baseTalent2 = operatorForm.baseTalent2,
                combatTalent1 = operatorForm.combatTalent1,
                combatTalent2 = operatorForm.combatTalent2,
                p1 = operatorForm.p1,
                p1Effect = operatorForm.p1Effect,
                p2 = operatorForm.p2,
                p2Effect = operatorForm.p2Effect,
                p3 = operatorForm.p3,
                p3Effect = operatorForm.p3Effect,
                p4 = operatorForm.p4,
                p4Effect = operatorForm.p4Effect,
                p5 = operatorForm.p5,
                p5Effect = operatorForm.p5Effect,
                conceptArt1 = operatorForm.conceptArt1,
                conceptArt2 = operatorForm.conceptArt2,
                conceptArt3 = operatorForm.conceptArt3
            )
            operatorService.saveOperator(operator)
        }

        return "redirect:/endfield/admin/operators"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        val operator = operatorService.getOperatorById(id) ?: return "redirect:/endfield/admin/operators"

        // Convertir Entity a FormDTO
        val operatorForm = OperatorFormDTO(
            id = operator.id,
            name = operator.name,
            rarityId = operator.rarity.id,
            imageUrl = operator.imageUrl,
            elementId = operator.element.id,
            weaponTypeId = operator.weaponType.id,
            operatorClassId = operator.operatorClass.id,
            strength = operator.strength,
            agility = operator.agility,
            intellect = operator.intellect,
            will = operator.will,
            basicAttack = operator.basicAttack,
            basicAttackDescription = operator.basicAttackDescription,
            battleSkill = operator.battleSkill,
            battleSkillDescription = operator.battleSkillDescription,
            battleSkillSpCost = operator.battleSkillSpCost,
            comboSkill = operator.comboSkill,
            comboSkillDescription = operator.comboSkillDescription,
            comboSkillCooldown = operator.comboSkillCooldown,
            ultimate = operator.ultimate,
            ultimateDescription = operator.ultimateDescription,
            ultimateEnergyCost = operator.ultimateEnergyCost,
            baseTalent1 = operator.baseTalent1,
            baseTalent2 = operator.baseTalent2,
            combatTalent1 = operator.combatTalent1,
            combatTalent2 = operator.combatTalent2,
            p1 = operator.p1,
            p1Effect = operator.p1Effect,
            p2 = operator.p2,
            p2Effect = operator.p2Effect,
            p3 = operator.p3,
            p3Effect = operator.p3Effect,
            p4 = operator.p4,
            p4Effect = operator.p4Effect,
            p5 = operator.p5,
            p5Effect = operator.p5Effect,
            conceptArt1 = operator.conceptArt1,
            conceptArt2 = operator.conceptArt2,
            conceptArt3 = operator.conceptArt3
        )

        model.addAttribute("operatorForm", operatorForm)
        model.addAttribute("rarities", referenceDataService.getAllRarities())
        model.addAttribute("elements", referenceDataService.getAllElements())
        model.addAttribute("weaponTypes", referenceDataService.getAllWeaponTypes())
        model.addAttribute("operatorClasses", referenceDataService.getAllOperatorClasses())
        return "admin/operators/edit"
    }

    @PostMapping("/edit/{id}")
    fun updateOperator(
        @PathVariable id: Long,
        @ModelAttribute operatorForm: OperatorFormDTO
    ): String {
        val existingOperator = operatorService.getOperatorById(id) ?: return "redirect:/endfield/admin/operators"

        val rarity = operatorForm.rarityId?.let { referenceDataService.getRarityById(it) }
        val element = operatorForm.elementId?.let { referenceDataService.getElementById(it) }
        val weaponType = operatorForm.weaponTypeId?.let { referenceDataService.getWeaponTypeById(it) }
        val operatorClass = operatorForm.operatorClassId?.let { referenceDataService.getOperatorClassById(it) }

        if (rarity != null && element != null && weaponType != null && operatorClass != null) {
            val updatedOperator = existingOperator.copy(
                name = operatorForm.name,
                imageUrl = operatorForm.imageUrl,
                rarity = rarity,
                element = element,
                weaponType = weaponType,
                operatorClass = operatorClass,
                strength = operatorForm.strength,
                agility = operatorForm.agility,
                intellect = operatorForm.intellect,
                will = operatorForm.will,
                basicAttack = operatorForm.basicAttack,
                basicAttackDescription = operatorForm.basicAttackDescription,
                battleSkill = operatorForm.battleSkill,
                battleSkillDescription = operatorForm.battleSkillDescription,
                battleSkillSpCost = operatorForm.battleSkillSpCost,
                comboSkill = operatorForm.comboSkill,
                comboSkillDescription = operatorForm.comboSkillDescription,
                comboSkillCooldown = operatorForm.comboSkillCooldown,
                ultimate = operatorForm.ultimate,
                ultimateDescription = operatorForm.ultimateDescription,
                ultimateEnergyCost = operatorForm.ultimateEnergyCost,
                baseTalent1 = operatorForm.baseTalent1,
                baseTalent2 = operatorForm.baseTalent2,
                combatTalent1 = operatorForm.combatTalent1,
                combatTalent2 = operatorForm.combatTalent2,
                p1 = operatorForm.p1,
                p1Effect = operatorForm.p1Effect,
                p2 = operatorForm.p2,
                p2Effect = operatorForm.p2Effect,
                p3 = operatorForm.p3,
                p3Effect = operatorForm.p3Effect,
                p4 = operatorForm.p4,
                p4Effect = operatorForm.p4Effect,
                p5 = operatorForm.p5,
                p5Effect = operatorForm.p5Effect,
                conceptArt1 = operatorForm.conceptArt1,
                conceptArt2 = operatorForm.conceptArt2,
                conceptArt3 = operatorForm.conceptArt3
            )
            operatorService.saveOperator(updatedOperator)
        }

        return "redirect:/endfield/admin/operators"
    }

    @PostMapping("/delete/{id}")
    fun deleteOperator(@PathVariable id: Long): String {
        operatorService.deleteOperator(id)
        return "redirect:/endfield/admin/operators"
    }
}