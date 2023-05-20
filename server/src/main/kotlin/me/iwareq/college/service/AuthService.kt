package me.iwareq.college.service

import me.iwareq.college.controller.request.AuthRequest
import me.iwareq.college.controller.request.RegisterRequest
import me.iwareq.college.controller.response.AuthResponse
import me.iwareq.college.model.User
import me.iwareq.college.model.UserDetailsImpl
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
	private val userService: UserService,
	private val passwordEncoder: PasswordEncoder,
	private val securityService: SecurityService,
	private val authManager: AuthenticationManager
) {

	fun register(request: RegisterRequest): AuthResponse {
		val user = User(
			firstName = request.firstName,
			lastName = request.lastName,
			email = request.email,
			password = this.passwordEncoder.encode(request.password),
			roles = request.roles
		)

		val savedUser = UserDetailsImpl.fromUser(this.userService.addUser(user))

		val jwt = this.securityService.generateToken(userDetails = savedUser)
		return AuthResponse(jwt)
	}

	fun authenticate(request: AuthRequest): AuthResponse {
		this.authManager.authenticate(UsernamePasswordAuthenticationToken(request.email, request.password))

		val user = UserDetailsImpl.fromUser(this.userService.getUser(request.email))

		val jwt = this.securityService.generateToken(userDetails = user)
		return AuthResponse(jwt)
	}
}
