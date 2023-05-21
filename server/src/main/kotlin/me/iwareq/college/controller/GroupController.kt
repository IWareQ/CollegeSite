package me.iwareq.college.controller

import me.iwareq.college.service.GroupService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/groups")
class GroupController(private val service: GroupService) {

	@GetMapping
	fun getAll() = this.service.getAll()

	@GetMapping("/{id}")
	fun getGroup(@PathVariable id: Long) = ResponseEntity.ok(this.service.getGroup(id))

	@DeleteMapping("/{id}")
	fun deleteGroup(@PathVariable id: Long) = this.service.deleteGroup(id)
}
