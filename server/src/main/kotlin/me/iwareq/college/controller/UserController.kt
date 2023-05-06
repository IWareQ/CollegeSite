package me.iwareq.college.controller

import me.iwareq.college.model.User
import me.iwareq.college.model.exception.UserNotFoundException
import me.iwareq.college.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/users")
class UserController(val service: UserService) {

	@GetMapping
	fun getAll() = this.service.getAll()

	@GetMapping("/{id}")
	fun getUser(@PathVariable id: Long): Any? {
		return try {
			val user = this.service.getUser(id)
			ResponseEntity.ok(user)
		} catch (exception: UserNotFoundException) {
			exception.message
		}
	}

	@PostMapping
	fun addUser(@RequestBody user: User) = this.service.addUser(user)

	@DeleteMapping("/{id}")
	fun deleteUser(@PathVariable id: Long) = this.service.deleteUser(id)
}
