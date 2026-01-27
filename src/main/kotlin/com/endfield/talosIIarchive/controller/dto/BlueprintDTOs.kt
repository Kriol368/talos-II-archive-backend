package com.endfield.talosIIarchive.controller.dto

import com.endfield.talosIIarchive.model.Blueprint
import java.time.format.DateTimeFormatter

data class BlueprintSummaryDTO(
    val id: Long, val title: String, val description: String?, val codeHash: String, val createdAt: String
)

data class CreateBlueprintRequestDTO(
    val title: String, val description: String? = null, val codeHash: String
)

private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

fun Blueprint.toSummaryDTO() = BlueprintSummaryDTO(
    id = this.id,
    title = this.title,
    description = this.description,
    codeHash = this.codeHash,
    createdAt = this.createdAt.format(dateFormatter)
)
