package me.iwareq.college.model

import jakarta.persistence.*
import org.springframework.security.core.authority.SimpleGrantedAuthority

@Entity
@Table(name = "users")
data class User(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long = -1,

	var firstName: String,
	var lastName: String,

	val email: String,
	val password: String,

	@Enumerated(EnumType.STRING)
	val roles: Set<Role> = setOf(Role.STUDENT)
) {

	fun getAuthorities() = this.roles.map { SimpleGrantedAuthority("ROLE_${it.name}") }
}
