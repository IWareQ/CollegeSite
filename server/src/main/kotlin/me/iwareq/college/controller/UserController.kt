package me.iwareq.college.controller

import me.iwareq.college.model.User
import me.iwareq.college.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userService: UserService) {

	@GetMapping
	fun getAll() = this.userService.getAll()

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	fun getUser(@PathVariable id: Long): ResponseEntity<User> {
		val user = this.userService.getUser(id)
		return ResponseEntity.ok(user)
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	fun deleteUser(@PathVariable id: Long) = this.userService.deleteUser(id)
}
