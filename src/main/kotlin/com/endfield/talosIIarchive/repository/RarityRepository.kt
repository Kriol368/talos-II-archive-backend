package com.endfield.talosIIarchive.repository

import com.endfield.talosIIarchive.model.Rarity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RarityRepository : JpaRepository<Rarity, Long> {
    fun findByStars(stars: Int): Rarity?
}