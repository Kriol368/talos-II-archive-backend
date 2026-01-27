package com.endfield.talosIIarchive.controller

import com.endfield.talosIIarchive.controller.dto.*
import com.endfield.talosIIarchive.service.BlueprintService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/endfield/blueprints")
class BlueprintController(private val blueprintService: BlueprintService) {

    @GetMapping
    fun getAllBlueprints(): List<BlueprintSummaryDTO> {
        return blueprintService.getAllBlueprints().map { it.toSummaryDTO() }
    }

    @PostMapping
    fun createBlueprint(@RequestBody request: CreateBlueprintRequestDTO): ResponseEntity<BlueprintSummaryDTO> {
        val blueprint = blueprintService.createBlueprint(
            title = request.title, description = request.description, codeHash = request.codeHash
        )
        return ResponseEntity.status(HttpStatus.CREATED).body(blueprint.toSummaryDTO())
    }

}