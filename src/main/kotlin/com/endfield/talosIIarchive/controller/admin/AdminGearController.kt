package com.endfield.talosIIarchive.controller.admin

import com.endfield.talosIIarchive.controller.admin.dto.GearFormDTO
import com.endfield.talosIIarchive.model.Gear
import com.endfield.talosIIarchive.service.GearService
import com.endfield.talosIIarchive.service.ReferenceDataService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/endfield/admin/gear")
class AdminGearController(
    private val gearService: GearService,
    private val referenceDataService: ReferenceDataService
) {

    @GetMapping
    fun listGear(model: Model): String {
        model.addAttribute("gearList", gearService.getAllGear())
        return "admin/gear/list"
    }

    @GetMapping("/create")
    fun showCreateForm(model: Model): String {
        model.addAttribute("gearForm", GearFormDTO())  // Usa DTO
        model.addAttribute("gearTypes", referenceDataService.getAllGearTypes())
        model.addAttribute("gearSets", referenceDataService.getAllGearSets())
        return "admin/gear/create"
    }

    @PostMapping("/create")
    fun createGear(@ModelAttribute gearForm: GearFormDTO): String {
        val gearType = gearForm.gearTypeId?.let { referenceDataService.getGearTypeById(it) }
        val gearSet = gearForm.gearSetId?.let { referenceDataService.getGearSetById(it) }

        if (gearType != null && gearSet != null) {
            val gear = Gear(
                name = gearForm.name,
                imageUrl = gearForm.imageUrl,
                gearType = gearType,
                gearSet = gearSet,
                attribute1 = gearForm.attribute1,
                attribute2 = gearForm.attribute2,
                attribute3 = gearForm.attribute3,
                def = gearForm.def
            )
            gearService.saveGear(gear)
        }

        return "redirect:/endfield/admin/gear"
    }

    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        val gear = gearService.getGearById(id) ?: return "redirect:/endfield/admin/gear"

        // Convertir Entity a FormDTO
        val gearForm = GearFormDTO(
            id = gear.id,
            name = gear.name,
            imageUrl = gear.imageUrl,
            gearTypeId = gear.gearType.id,
            gearSetId = gear.gearSet.id,
            attribute1 = gear.attribute1,
            attribute2 = gear.attribute2,
            attribute3 = gear.attribute3,
            def = gear.def
        )

        model.addAttribute("gearForm", gearForm)
        model.addAttribute("gearTypes", referenceDataService.getAllGearTypes())
        model.addAttribute("gearSets", referenceDataService.getAllGearSets())
        return "admin/gear/edit"
    }

    @PostMapping("/edit/{id}")
    fun updateGear(
        @PathVariable id: Long,
        @ModelAttribute gearForm: GearFormDTO
    ): String {
        val existingGear = gearService.getGearById(id) ?: return "redirect:/endfield/admin/gear"

        val gearType = gearForm.gearTypeId?.let { referenceDataService.getGearTypeById(it) }
        val gearSet = gearForm.gearSetId?.let { referenceDataService.getGearSetById(it) }

        if (gearType != null && gearSet != null) {
            val updatedGear = existingGear.copy(
                name = gearForm.name,
                imageUrl = gearForm.imageUrl,
                gearType = gearType,
                gearSet = gearSet,
                attribute1 = gearForm.attribute1,
                attribute2 = gearForm.attribute2,
                attribute3 = gearForm.attribute3,
                def = gearForm.def
            )
            gearService.saveGear(updatedGear)
        }

        return "redirect:/endfield/admin/gear"
    }

    @PostMapping("/delete/{id}")
    fun deleteGear(@PathVariable id: Long): String {
        gearService.deleteGear(id)
        return "redirect:/endfield/admin/gear"
    }
}