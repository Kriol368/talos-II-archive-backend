package com.endfield.talosIIarchive.model

import jakarta.persistence.*

@Entity
@Table(name = "team_operator")
data class TeamOperator(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,

    @ManyToOne @JoinColumn(name = "team_id", nullable = false) val team: Team,

    @ManyToOne @JoinColumn(name = "operator_id", nullable = false) val operator: Operator,

    @Column(nullable = false) val position: Int
)