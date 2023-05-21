package me.iwareq.college.controller

import me.iwareq.college.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/users")
class UserController(private val service: UserService) {

	@GetMapping
	fun getAll() = this.service.getAll()

	@GetMapping("/{id}")
	fun getUser(@PathVariable id: Long) = ResponseEntity.ok(this.service.getUser(id))

	@DeleteMapping("/{id}")
	fun deleteUser(@PathVariable id: Long) = this.service.deleteUser(id)
}
