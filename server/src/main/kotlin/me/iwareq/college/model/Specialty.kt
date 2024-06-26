package me.iwareq.college.model

import jakarta.persistence.*

@Entity
@Table(name = "specialties")
data class Specialty(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = -1,

	var okpdtr: String,
	var title: String,
)
