package me.iwareq.college.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "students")
data class Student(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = -1,

	@OneToOne
	@JoinColumn(name = "user_id")
	var user: User,

	@OneToOne
	@JoinColumn(name = "specialty_id")
	var specialty: Specialty,

	@Enumerated(EnumType.STRING)
	var studyForm: StudyForm,

	var admissionDate: LocalDate,
	var dateOfIssue: LocalDate,
)
