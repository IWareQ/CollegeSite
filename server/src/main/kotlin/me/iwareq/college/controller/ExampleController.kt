package me.iwareq.college.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/example")
class ExampleController {

	@GetMapping
	fun getExample() = "Да, правильно, оно работает"
}
