package com.endfield.talosIIarchive.model

import jakarta.persistence.*

@Entity
@Table(name = "operator_class")
data class OperatorClass(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true, length = 50)
    val name: String
)