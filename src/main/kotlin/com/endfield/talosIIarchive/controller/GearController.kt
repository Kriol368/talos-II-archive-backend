package com.endfield.talosIIarchive.controller

import com.endfield.talosIIarchive.controller.dto.GearDetailDTO
import com.endfield.talosIIarchive.controller.dto.GearSummaryDTO
import com.endfield.talosIIarchive.controller.dto.toDetailDTO
import com.endfield.talosIIarchive.controller.dto.toSummaryDTO
import com.endfield.talosIIarchive.service.GearService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/endfield/gear")
class GearController(private val gearService: GearService) {

    @GetMapping
    fun getAllGear(): List<GearSummaryDTO> {
        return gearService.getAllGear().map { it.toSummaryDTO() }
    }

    @GetMapping("/{id}")
    fun getGearById(@PathVariable id: Long): ResponseEntity<GearDetailDTO> {
        val gear = gearService.getGearById(id)
        return if (gear != null) ResponseEntity.ok(gear.toDetailDTO())
        else ResponseEntity.notFound().build()
    }
}