package com.endfield.talosIIarchive.controller

import com.endfield.talosIIarchive.controller.dto.OperatorDetailDTO
import com.endfield.talosIIarchive.controller.dto.OperatorSummaryDTO
import com.endfield.talosIIarchive.controller.dto.toDetailDTO
import com.endfield.talosIIarchive.controller.dto.toSummaryDTO
import com.endfield.talosIIarchive.service.OperatorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/endfield/operators")
class OperatorController(private val operatorService: OperatorService) {

    @GetMapping
    fun getAllOperators(): List<OperatorSummaryDTO> {
        return operatorService.getAllOperators().map { it.toSummaryDTO() }
    }

    @GetMapping("/{id}")
    fun getOperatorById(@PathVariable id: Long): ResponseEntity<OperatorDetailDTO> {
        val operator = operatorService.getOperatorById(id)
        return if (operator != null) ResponseEntity.ok(operator.toDetailDTO())
        else ResponseEntity.notFound().build()
    }
}