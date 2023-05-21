package me.iwareq.college.repository

import me.iwareq.college.model.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long>
