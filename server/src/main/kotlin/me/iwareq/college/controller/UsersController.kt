package me.iwareq.college.controller

import me.iwareq.college.model.User
import me.iwareq.college.service.UsersService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/users")
class UsersController(val service: UsersService) {

	@GetMapping
	fun getAll() = this.service.getAll()

	@GetMapping("/{id}")
	fun getUser(@PathVariable id: Long): ResponseEntity<*> {
		val user = this.service.getUser(id)
		return ResponseEntity.ok(user)
	}

	@PostMapping
	fun addUser(@RequestBody user: User) = this.service.addUser(user)

	@DeleteMapping("/{id}")
	fun deleteUser(@PathVariable id: Long) = this.service.deleteUser(id)
}
