package me.iwareq.college.model.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class UserNotFoundException : ResponseStatusException(
	HttpStatus.NOT_FOUND, "User not found"
)
