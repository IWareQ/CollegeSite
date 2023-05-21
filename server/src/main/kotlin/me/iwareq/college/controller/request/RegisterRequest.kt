package me.iwareq.college.controller.request

data class RegisterRequest(
	val firstName: String,
	val lastName: String,
	val middleName: String,
	val email: String,
	val password: String
)
