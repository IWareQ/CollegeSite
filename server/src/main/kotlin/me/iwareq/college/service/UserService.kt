package me.iwareq.college.service

import me.iwareq.college.model.User
import me.iwareq.college.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val repository: UserRepository) {

	fun getAll(): MutableList<User> = this.repository.findAll()

	fun addUser(user: User) {
		this.repository.save(user)
	}
}
