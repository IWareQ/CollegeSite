package me.iwareq.college.controller

import me.iwareq.college.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/students")
class StudentController(private val service: StudentService) {

	@GetMapping
	fun getAll() = this.service.getAll()

	@GetMapping("/{id}")
	fun getStudent(@PathVariable id: Long) = ResponseEntity.ok(this.service.getStudent(id))

	@DeleteMapping("/{id}")
	fun deleteStudent(@PathVariable id: Long) = this.service.deleteStudent(id)
}
