package com.endfield.talosIIarchive.controller.admin

import com.endfield.talosIIarchive.service.OperatorService
import com.endfield.talosIIarchive.service.WeaponService
import com.endfield.talosIIarchive.service.GearService
import com.endfield.talosIIarchive.service.TeamService
import com.endfield.talosIIarchive.service.BlueprintService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/endfield/admin")
class AdminDashboardController(
    private val operatorService: OperatorService,
    private val weaponService: WeaponService,
    private val gearService: GearService,
    private val teamService: TeamService,
    private val blueprintService: BlueprintService
) {

    @GetMapping
    fun dashboard(model: Model): String {
        model.addAttribute("title", "Dashboard")
        model.addAttribute("icon", "bi-speedometer2")

        model.addAttribute("totalOperators", operatorService.getAllOperators().size)
        model.addAttribute("totalWeapons", weaponService.getAllWeapons().size)
        model.addAttribute("totalGear", gearService.getAllGear().size)
        model.addAttribute("totalTeams", teamService.getAllTeams().size)
        model.addAttribute("totalBlueprints", blueprintService.getAllBlueprints().size)

        return "admin/index"
    }
}