package me.iwareq.college.service

import me.iwareq.college.exception.ModelNotFoundException
import me.iwareq.college.model.Subject
import me.iwareq.college.repository.SubjectRepository
import org.springframework.stereotype.Service

@Service
class SubjectService(private val repository: SubjectRepository) {

	fun getAll(): MutableList<Subject> = this.repository.findAll()

	fun addSubject(subject: Subject) = this.repository.save(subject)

	fun getSubject(id: Long): Subject = this.repository.findById(id).orElseThrow {
		throw ModelNotFoundException("Subject not found with id: $id")
	}

	fun deleteSubject(id: Long) = this.repository.deleteById(id)
}
