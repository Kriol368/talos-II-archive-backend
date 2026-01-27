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
}