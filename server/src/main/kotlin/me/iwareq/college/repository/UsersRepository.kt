package me.iwareq.college.repository

import me.iwareq.college.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository : JpaRepository<User, Long>
