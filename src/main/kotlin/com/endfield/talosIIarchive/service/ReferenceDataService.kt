package com.endfield.talosIIarchive.service

import com.endfield.talosIIarchive.model.*
import com.endfield.talosIIarchive.repository.*
import org.springframework.stereotype.Service

@Service
class ReferenceDataService(
    private val rarityRepository: RarityRepository,
    private val weaponTypeRepository: WeaponTypeRepository,
    private val elementRepository: ElementRepository,
    private val operatorClassRepository: OperatorClassRepository,
    private val gearTypeRepository: GearTypeRepository,
    private val gearSetRepository: GearSetRepository
) {

    fun getAllRarities(): List<Rarity> = rarityRepository.findAll()
    fun getRarityByStars(stars: Int): Rarity? = rarityRepository.findByStars(stars)
    fun getRarityById(id: Long): Rarity? = rarityRepository.findById(id).orElse(null)

    fun getAllWeaponTypes(): List<WeaponType> = weaponTypeRepository.findAll()
    fun getWeaponTypeByName(name: String): WeaponType? = weaponTypeRepository.findByName(name)
    fun getWeaponTypeById(id: Long): WeaponType? = weaponTypeRepository.findById(id).orElse(null)

    fun getAllElements(): List<Element> = elementRepository.findAll()
    fun getElementByName(name: String): Element? = elementRepository.findByName(name)
    fun getElementById(id: Long): Element? = elementRepository.findById(id).orElse(null)

    fun getAllOperatorClasses(): List<OperatorClass> = operatorClassRepository.findAll()
    fun getOperatorClassByName(name: String): OperatorClass? = operatorClassRepository.findByName(name)
    fun getOperatorClassById(id: Long): OperatorClass? = operatorClassRepository.findById(id).orElse(null)

    fun getAllGearTypes(): List<GearType> = gearTypeRepository.findAll()
    fun getGearTypeByName(name: String): GearType? = gearTypeRepository.findByName(name)
    fun getGearTypeById(id: Long): GearType? = gearTypeRepository.findById(id).orElse(null)

    fun getAllGearSets(): List<GearSet> = gearSetRepository.findAll()
    fun getGearSetByName(name: String): GearSet? = gearSetRepository.findByName(name)
    fun getGearSetById(id: Long): GearSet? = gearSetRepository.findById(id).orElse(null)

    fun saveRarity(rarity: Rarity): Rarity = rarityRepository.save(rarity)
    fun saveWeaponType(weaponType: WeaponType): WeaponType = weaponTypeRepository.save(weaponType)
    fun saveElement(element: Element): Element = elementRepository.save(element)
    fun saveOperatorClass(operatorClass: OperatorClass): OperatorClass = operatorClassRepository.save(operatorClass)
    fun saveGearType(gearType: GearType): GearType = gearTypeRepository.save(gearType)
    fun saveGearSet(gearSet: GearSet): GearSet = gearSetRepository.save(gearSet)
}