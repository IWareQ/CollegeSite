package me.iwareq.college.controller

import me.iwareq.college.model.Specialty
import me.iwareq.college.service.SpecialtyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/specialties")
class SpecialtyController(private val service: SpecialtyService) {

	@GetMapping
	fun getAll() = this.service.getAll()

	@GetMapping("/{id}")
	fun getSpecialty(@PathVariable id: Long) = ResponseEntity.ok(this.service.getSpecialty(id))

	@PostMapping
	fun addSpecialty(@RequestBody specialty: Specialty) = ResponseEntity.ok(this.service.addSpecialty(specialty))

	@DeleteMapping("/{id}")
	fun deleteSpecialty(@PathVariable id: Long) = this.service.deleteSpecialty(id)
}
