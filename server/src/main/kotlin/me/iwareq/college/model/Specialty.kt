package me.iwareq.college.model

import jakarta.persistence.*

@Entity
@Table(name = "specialties")
class Specialty(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long = -1,

	val okpdtr: String,
	val title: String,
	@Lob
	val description: String
)
