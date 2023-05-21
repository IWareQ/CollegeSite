package me.iwareq.college.model

import jakarta.persistence.*
import org.springframework.security.core.authority.SimpleGrantedAuthority

@Entity
@Table(name = "users")
data class User(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = -1,

	var firstName: String,
	var lastName: String,
	var middleName: String,

	var email: String,
	var password: String,

	@Enumerated(EnumType.STRING)
	val roles: MutableSet<Role> = mutableSetOf(Role.STUDENT)
) {

	fun getAuthorities() = this.roles.map { SimpleGrantedAuthority("ROLE_${it.name}") }
}
