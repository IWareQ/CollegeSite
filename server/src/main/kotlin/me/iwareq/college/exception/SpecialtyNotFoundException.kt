package me.iwareq.college.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class SpecialtyNotFoundException(text: String) : ResponseStatusException(HttpStatus.NOT_FOUND, text)
