package me.iwareq.college.service

import me.iwareq.college.exception.ModelNotFoundException
import me.iwareq.college.model.Specialty
import me.iwareq.college.repository.SpecialtyRepository
import org.springframework.stereotype.Service

@Service
class SpecialtyService(private val repository: SpecialtyRepository) {

	fun getAll(): MutableList<Specialty> = this.repository.findAll()

	fun addSpecialty(specialty: Specialty) = this.repository.save(specialty)

	fun getSpecialty(id: Long): Specialty = this.repository.findById(id).orElseThrow {
		throw ModelNotFoundException("Specialty not found with id: $id")
	}

	fun deleteSpecialty(id: Long) = this.repository.deleteById(id)
}
