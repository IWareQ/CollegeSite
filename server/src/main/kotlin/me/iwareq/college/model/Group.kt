package me.iwareq.college.model

import jakarta.persistence.*

@Entity
@Table(name = "groups")
data class Group(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = -1,

	var title: String,

	@OneToMany
	@JoinColumn(name = "group_id")
	val students: MutableSet<Student> = mutableSetOf(),

	@OneToOne
	@JoinColumn(name = "teacher_id")
	var classLeader: Teacher
)
