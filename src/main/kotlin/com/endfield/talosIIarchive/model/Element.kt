package com.endfield.talosIIarchive.model

import jakarta.persistence.*

@Entity
@Table(name = "element")
data class Element(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true, length = 50)
    val name: String
)