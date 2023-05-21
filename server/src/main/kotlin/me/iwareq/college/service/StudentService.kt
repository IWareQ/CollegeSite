package me.iwareq.college.service

import me.iwareq.college.exception.ModelNotFoundException
import me.iwareq.college.model.Student
import me.iwareq.college.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(private val repository: StudentRepository) {

	fun getAll(): MutableList<Student> = this.repository.findAll()

	fun addStudent(student: Student) = this.repository.save(student)

	fun getStudent(id: Long): Student = this.repository.findById(id).orElseThrow {
		throw ModelNotFoundException("Student not found with id: $id")
	}

	fun deleteStudent(id: Long) = this.repository.deleteById(id)
}
