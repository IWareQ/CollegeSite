package me.iwareq.college.model

import jakarta.persistence.*

@Entity
@Table(name = "teachers")
data class Teacher(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = -1,

	@OneToOne
	@JoinColumn(name = "user_id")
	var user: User,

	@OneToMany(cascade = [CascadeType.REMOVE])
	@JoinColumn(name = "teacher_id")
	val subjects: MutableSet<Subject> = mutableSetOf()
)
