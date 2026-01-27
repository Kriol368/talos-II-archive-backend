package com.endfield.talosIIarchive.service

import com.endfield.talosIIarchive.model.Blueprint
import com.endfield.talosIIarchive.repository.BlueprintRepository
import org.springframework.stereotype.Service

@Service
class BlueprintService(
    private val blueprintRepository: BlueprintRepository
) {

    fun getAllBlueprints(): List<Blueprint> {
        return blueprintRepository.findAllByOrderByCreatedAtDesc()
    }

    fun createBlueprint(title: String, description: String?, codeHash: String): Blueprint {
        val blueprint = Blueprint(
            title = title,
            description = description,
            codeHash = codeHash
        )
        return blueprintRepository.save(blueprint)
    }

}