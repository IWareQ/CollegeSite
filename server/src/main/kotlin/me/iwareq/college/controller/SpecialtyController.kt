package me.iwareq.college.controller

import me.iwareq.college.model.Specialty
import me.iwareq.college.service.SpecialtyService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/specialties")
class SpecialtyController(private val service: SpecialtyService) {

	@GetMapping
	fun getAll() = this.service.getAll()

	@GetMapping("/{id}")
	fun getSpecialty(@PathVariable id: Long): ResponseEntity<Specialty> {
		val specialty = this.service.getSpecialty(id)
		return ResponseEntity.ok(specialty)
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	fun addSpecialty(@RequestBody specialty: Specialty) = this.service.addSpecialty(specialty)

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	fun deleteSpecialty(@PathVariable id: Long) = this.service.deleteSpecialty(id)
}
