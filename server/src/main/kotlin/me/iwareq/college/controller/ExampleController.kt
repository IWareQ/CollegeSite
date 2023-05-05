package me.iwareq.college.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
class ExampleController {

	@GetMapping("/example")
	fun getExample() = "Да, правильно, оно работает"
}
