package me.iwareq.college.controller

import me.iwareq.college.controller.request.AuthRequest
import me.iwareq.college.controller.request.RegisterRequest
import me.iwareq.college.controller.response.AuthResponse
import me.iwareq.college.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/auth")
class AuthController(private val service: AuthService) {

	@PostMapping("/register")
	fun register(@RequestBody request: RegisterRequest): ResponseEntity<Any> {
		this.service.register(request)
		return ResponseEntity.ok().build()
	}

	@PostMapping("/login")
	fun authenticate(@RequestBody request: AuthRequest): ResponseEntity<AuthResponse> =
		ResponseEntity.ok(this.service.authenticate(request))
}
