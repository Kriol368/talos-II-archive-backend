package com.endfield.talosIIarchive.controller.admin

import com.endfield.talosIIarchive.controller.admin.dto.WeaponFormDTO
import com.endfield.talosIIarchive.model.Weapon
import com.endfield.talosIIarchive.service.WeaponService
import com.endfield.talosIIarchive.service.ReferenceDataService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/endfield/admin/weapons")
class AdminWeaponController(
    private val weaponService: WeaponService,
    private val referenceDataService: ReferenceDataService
) {

    @GetMapping
    fun listWeapons(model: Model): String {
        model.addAttribute("weapons", weaponService.getAllWeapons())
        return "admin/weapons/list"
    }

    @GetMapping("/create")
    fun showCreateForm(model: Model): String {
        model.addAttribute("weaponForm", WeaponFormDTO())  // Usa DTO
        model.addAttribute("rarities", referenceDataService.getAllRarities())
        model.addAttribute("weaponTypes", referenceDataService.getAllWeaponTypes())
        return "admin/weapons/create"
    }

    @PostMapping("/create")
    fun createWeapon(@ModelAttribute weaponForm: WeaponFormDTO): String {
        val rarity = weaponForm.rarityId?.let { referenceDataService.getRarityById(it) }
        val weaponType = weaponForm.weaponTypeId?.let { referenceDataService.getWeaponTypeById(it) }

        if (rarity != null && weaponType != null) {
            val weapon = Weapon(
                name = weaponForm.name,
                rarity = rarity,
                imageUrl = weaponForm.imageUrl,
                weaponType = weaponType,
                baseAtk = weaponForm.baseAtk,
                stat1 = weaponForm.stat1,
                stat2 = weaponForm.stat2,
                passive = weaponForm.passive
            )
            weaponService.saveWeapon(weapon)
        }

        return "redirect:/endfield/admin/weapons"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        val weapon = weaponService.getWeaponById(id) ?: return "redirect:/endfield/admin/weapons"

        // Convertir Entity a FormDTO
        val weaponForm = WeaponFormDTO(
            id = weapon.id,
            name = weapon.name,
            rarityId = weapon.rarity.id,
            imageUrl = weapon.imageUrl,
            weaponTypeId = weapon.weaponType.id,
            baseAtk = weapon.baseAtk,
            stat1 = weapon.stat1,
            stat2 = weapon.stat2,
            passive = weapon.passive
        )

        model.addAttribute("weaponForm", weaponForm)
        model.addAttribute("rarities", referenceDataService.getAllRarities())
        model.addAttribute("weaponTypes", referenceDataService.getAllWeaponTypes())
        return "admin/weapons/edit"
    }

    @PostMapping("/edit/{id}")
    fun updateWeapon(
        @PathVariable id: Long,
        @ModelAttribute weaponForm: WeaponFormDTO
    ): String {
        val existingWeapon = weaponService.getWeaponById(id) ?: return "redirect:/endfield/admin/weapons"

        val rarity = weaponForm.rarityId?.let { referenceDataService.getRarityById(it) }
        val weaponType = weaponForm.weaponTypeId?.let { referenceDataService.getWeaponTypeById(it) }

        if (rarity != null && weaponType != null) {
            val updatedWeapon = existingWeapon.copy(
                name = weaponForm.name,
                imageUrl = weaponForm.imageUrl,
                rarity = rarity,
                weaponType = weaponType,
                baseAtk = weaponForm.baseAtk,
                stat1 = weaponForm.stat1,
                stat2 = weaponForm.stat2,
                passive = weaponForm.passive
            )
            weaponService.saveWeapon(updatedWeapon)
        }

        return "redirect:/endfield/admin/weapons"
    }

    @PostMapping("/delete/{id}")
    fun deleteWeapon(@PathVariable id: Long): String {
        weaponService.deleteWeapon(id)
        return "redirect:/endfield/admin/weapons"
    }
}