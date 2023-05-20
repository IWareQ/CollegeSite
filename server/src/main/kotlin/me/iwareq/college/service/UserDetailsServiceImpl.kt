package me.iwareq.college.service

import me.iwareq.college.model.UserDetailsImpl
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val service: UserService) : UserDetailsService {

	override fun loadUserByUsername(email: String) = UserDetailsImpl.fromUser(this.service.getUser(email))
}
