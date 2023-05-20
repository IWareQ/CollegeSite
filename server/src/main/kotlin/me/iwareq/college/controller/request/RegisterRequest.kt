package me.iwareq.college.controller.request

import me.iwareq.college.model.Role

data class RegisterRequest(
	var firstName: String,
	var lastName: String,
	var email: String,
	var password: String,
	var roles: Set<Role>
)
