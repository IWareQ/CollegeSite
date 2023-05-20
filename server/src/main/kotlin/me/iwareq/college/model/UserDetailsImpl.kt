package me.iwareq.college.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(
	val id: Long,
	private val email: String,
	private val password: String,
	private val authorities: Collection<GrantedAuthority>
) : UserDetails {

	override fun getAuthorities() = this.authorities

	override fun getPassword() = this.password

	override fun getUsername() = this.email

	override fun isAccountNonExpired() = true

	override fun isAccountNonLocked() = true

	override fun isCredentialsNonExpired() = true

	override fun isEnabled() = true
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is UserDetailsImpl) return false

		return this.id == other.id
	}

	override fun hashCode() = this.id.hashCode()

	companion object {

		fun fromUser(user: User): UserDetails {
			val authorities = user.roles.map { SimpleGrantedAuthority("ROLE_${it.name}") }

			return UserDetailsImpl(
				user.id,
				user.email,
				user.password,
				authorities
			)
		}
	}
}
