package me.iwareq.college.repository

import me.iwareq.college.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

	fun findByEmail(email: String): User?
}
