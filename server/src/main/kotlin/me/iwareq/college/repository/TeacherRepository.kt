package me.iwareq.college.repository

import me.iwareq.college.model.Teacher
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepository : JpaRepository<Teacher, Long>
