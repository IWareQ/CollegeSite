package me.iwareq.college.service

import me.iwareq.college.exception.ModelNotFoundException
import me.iwareq.college.model.Specialty
import me.iwareq.college.repository.SpecialtiesRepository
import org.springframework.stereotype.Service

@Service
class SpecialtiesService(val repository: SpecialtiesRepository) {

	fun getAll(): MutableList<Specialty> = this.repository.findAll()

	fun addSpecialty(specialty: Specialty) {
		this.repository.save(specialty)
	}

	fun getSpecialty(id: Long): Specialty = this.repository.findById(id).orElseThrow {
		throw ModelNotFoundException("Specialty not found")
	}

	fun deleteSpecialty(id: Long) = this.repository.deleteById(id)
}
