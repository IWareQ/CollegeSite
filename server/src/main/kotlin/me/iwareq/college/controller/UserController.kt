package me.iwareq.college.controller

import me.iwareq.college.model.User
import me.iwareq.college.service.UserService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
class UserController(val service: UserService) {

	@GetMapping("/users")
	fun getAll() = this.service.getAll()

	@PostMapping("/users")
	fun addUser(@RequestBody user: User) = this.service.addUser(user)
}
