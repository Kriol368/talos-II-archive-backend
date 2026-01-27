package com.endfield.talosIIarchive.service

import com.endfield.talosIIarchive.model.Operator
import com.endfield.talosIIarchive.repository.OperatorRepository
import org.springframework.stereotype.Service

@Service
class OperatorService(
    private val operatorRepository: OperatorRepository
) {

    fun getAllOperators(): List<Operator> {
        return operatorRepository.findAll()
    }

    fun getOperatorById(id: Long): Operator? {
        return operatorRepository.findById(id).orElse(null)
    }

    fun getOperatorsByWeaponType(weaponTypeId: Long): List<Operator> {
        return operatorRepository.findByWeaponTypeId(weaponTypeId)
    }

    fun getOperatorsByElement(elementId: Long): List<Operator> {
        return operatorRepository.findByElementId(elementId)
    }

    fun getOperatorsByClass(operatorClassId: Long): List<Operator> {
        return operatorRepository.findByOperatorClassId(operatorClassId)
    }

    fun getOperatorsByRarity(rarityId: Long): List<Operator> {
        return operatorRepository.findByRarityId(rarityId)
    }

    fun searchOperatorsByName(name: String): List<Operator> {
        return operatorRepository.findByNameContainingIgnoreCase(name)
    }

    fun saveOperator(operator: Operator): Operator {
        return operatorRepository.save(operator)
    }

    fun deleteOperator(id: Long) {
        operatorRepository.deleteById(id)
    }
}