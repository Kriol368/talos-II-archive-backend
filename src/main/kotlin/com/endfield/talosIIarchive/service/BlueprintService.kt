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

    fun getBlueprintById(id: Long): Blueprint? {
        return blueprintRepository.findById(id).orElse(null)
    }

    fun searchBlueprintsByTitle(title: String): List<Blueprint> {
        return blueprintRepository.findByTitleContainingIgnoreCase(title)
    }

    fun getBlueprintsByCode(codeHash: String): List<Blueprint> {
        return blueprintRepository.findByCodeHash(codeHash)
    }

    fun createBlueprint(title: String, description: String?, codeHash: String): Blueprint {
        val blueprint = Blueprint(
            title = title, description = description, codeHash = codeHash
        )
        return blueprintRepository.save(blueprint)
    }

    fun deleteBlueprint(id: Long) {
        blueprintRepository.deleteById(id)
    }
}