package me.iwareq.college.service

import me.iwareq.college.exception.ModelNotFoundException
import me.iwareq.college.model.User
import me.iwareq.college.repository.UsersRepository
import org.springframework.stereotype.Service

@Service
class UsersService(val repository: UsersRepository) {

	fun getAll(): MutableList<User> = this.repository.findAll()

	fun addUser(user: User) {
		this.repository.save(user)
	}

	fun getUser(id: Long): User = this.repository.findById(id).orElseThrow {
		throw ModelNotFoundException("User not found")
	}

	fun deleteUser(id: Long) = this.repository.deleteById(id)
}
