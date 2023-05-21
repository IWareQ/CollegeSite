package me.iwareq.college.controller

import me.iwareq.college.service.SubjectService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/subjects")
class SubjectController(private val service: SubjectService) {

	@GetMapping
	fun getAll() = this.service.getAll()

	@GetMapping("/{id}")
	fun getSubject(@PathVariable id: Long) = ResponseEntity.ok(this.service.getSubject(id))

	@DeleteMapping("/{id}")
	fun deleteSubject(@PathVariable id: Long) = this.service.deleteSubject(id)
}
