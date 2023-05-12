package me.iwareq.college.controller

import me.iwareq.college.model.Specialty
import me.iwareq.college.service.SpecialtiesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/specialties")
class SpecialtiesController(val service: SpecialtiesService) {

	@GetMapping
	fun getAll() = this.service.getAll()

	@GetMapping("/{id}")
	fun getSpecialty(@PathVariable id: Long): ResponseEntity<*> {
		val specialty = this.service.getSpecialty(id)
		return ResponseEntity.ok(specialty)
	}

	@PostMapping
	fun addSpecialty(@RequestBody specialty: Specialty) = this.service.addSpecialty(specialty)

	@DeleteMapping("/{id}")
	fun deleteSpecialty(@PathVariable id: Long) = this.service.deleteSpecialty(id)
}
