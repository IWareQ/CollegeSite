package me.iwareq.college.security

import me.iwareq.college.security.jwt.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class WebSecurityConfig(
	private val authProvider: AuthenticationProvider,
	private val jwtAuthFilter: JwtAuthenticationFilter,
) {

	@Bean
	fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
		return http
			.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/api/v1/auth/login").permitAll()
			.anyRequest().permitAll()/*authenticated()*/
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authenticationProvider(this.authProvider)
			.addFilterBefore(this.jwtAuthFilter, UsernamePasswordAuthenticationFilter::class.java)
			.build()
	}
}
