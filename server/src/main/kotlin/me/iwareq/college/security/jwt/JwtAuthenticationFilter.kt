package me.iwareq.college.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import me.iwareq.college.service.SecurityService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
	private val securityService: SecurityService,
	private val userDetailsService: UserDetailsService
) : OncePerRequestFilter() {

	override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filter: FilterChain) {
		/*if (request.servletPath.contains("/api/v1/auth")) {
			filter.doFilter(request, response)
			return
		}*/

		val authHeader = request.getHeader("Authorization")
		if (this.isHeaderValid(authHeader)) {
			val jwt = authHeader.substring("Bearer ".length)

			val userEmail = this.securityService.extractEmail(jwt)
			if (userEmail != null && SecurityContextHolder.getContext().authentication == null) {
				val userDetails = this.userDetailsService.loadUserByUsername(userEmail)
				if (this.securityService.isTokenValid(jwt, userDetails)) {
					val authToken = UsernamePasswordAuthenticationToken(
						userDetails,
						null,
						userDetails.authorities
					)
					authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
					SecurityContextHolder.getContext().authentication = authToken
				}
			}
		}

		filter.doFilter(request, response)
	}

	private fun isHeaderValid(authHeader: String?) = authHeader != null && authHeader.startsWith("Bearer ")
}
