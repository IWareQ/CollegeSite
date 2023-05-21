package me.iwareq.college.model

import jakarta.persistence.*

@Entity
@Table(name = "subjects")
class Subject(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = -1,

	var title: String
)
