package com.endfield.talosIIarchive.controller

import com.endfield.talosIIarchive.controller.dto.WeaponDetailDTO
import com.endfield.talosIIarchive.controller.dto.WeaponSummaryDTO
import com.endfield.talosIIarchive.controller.dto.toDetailDTO
import com.endfield.talosIIarchive.controller.dto.toSummaryDTO
import com.endfield.talosIIarchive.service.WeaponService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/endfield/weapons")
class WeaponController(private val weaponService: WeaponService) {

    @GetMapping
    fun getAllWeapons(): List<WeaponSummaryDTO> {
        return weaponService.getAllWeapons().map { it.toSummaryDTO() }
    }

    @GetMapping("/{id}")
    fun getWeaponById(@PathVariable id: Long): ResponseEntity<WeaponDetailDTO> {
        val weapon = weaponService.getWeaponById(id)
        return if (weapon != null) ResponseEntity.ok(weapon.toDetailDTO())
        else ResponseEntity.notFound().build()
    }
}