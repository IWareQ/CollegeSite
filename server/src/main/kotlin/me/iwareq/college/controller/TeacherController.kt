package me.iwareq.college.controller

import me.iwareq.college.service.TeacherService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/teachers")
class TeacherController(private val service: TeacherService) {

	@GetMapping
	fun getAll() = this.service.getAll()

	@GetMapping("/{id}")
	fun getTeacher(@PathVariable id: Long) = ResponseEntity.ok(this.service.getTeacher(id))

	@DeleteMapping("/{id}")
	fun deleteTeacher(@PathVariable id: Long) = this.service.deleteTeacher(id)
}
