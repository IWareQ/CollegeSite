package me.iwareq.college.service

import me.iwareq.college.exception.UserNotFoundException
import me.iwareq.college.model.User
import me.iwareq.college.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

	fun getAll(): MutableList<User> = this.repository.findAll()

	fun addUser(user: User) = this.repository.save(user)

	fun getUser(id: Long): User = this.repository.findById(id).orElseThrow {
		throw UserNotFoundException("User not found with id: $id")
	}

	fun deleteUser(id: Long) = this.repository.deleteById(id)

	fun getUser(email: String): User = this.repository.findByEmail(email).orElseThrow {
		throw UserNotFoundException("User not found with email: $email")
	}
}
