package me.iwareq.college.service

import me.iwareq.college.exception.ModelNotFoundException
import me.iwareq.college.model.Teacher
import me.iwareq.college.repository.TeacherRepository
import org.springframework.stereotype.Service

@Service
class TeacherService(private val repository: TeacherRepository) {

	fun getAll(): MutableList<Teacher> = this.repository.findAll()

	fun addTeacher(teacher: Teacher) = this.repository.save(teacher)

	fun getTeacher(id: Long): Teacher = this.repository.findById(id).orElseThrow {
		throw ModelNotFoundException("Teacher not found with id: $id")
	}

	fun deleteTeacher(id: Long) = this.repository.deleteById(id)
}
