package me.iwareq.college.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long = 0,

	var firstname: String,
	var lastname: String,

	@Enumerated(EnumType.STRING)
	var role: Role = Role.STUDENT
)
