package me.iwareq.college.service

import me.iwareq.college.exception.ModelNotFoundException
import me.iwareq.college.model.Group
import me.iwareq.college.repository.GroupRepository
import org.springframework.stereotype.Service

@Service
class GroupService(private val repository: GroupRepository) {

	fun getAll(): MutableList<Group> = this.repository.findAll()

	fun addGroup(group: Group) = this.repository.save(group)

	fun getGroup(id: Long): Group = this.repository.findById(id).orElseThrow {
		throw ModelNotFoundException("Group not found with id: $id")
	}

	fun deleteGroup(id: Long) = this.repository.deleteById(id)
}
