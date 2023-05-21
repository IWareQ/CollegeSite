package me.iwareq.college.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import me.iwareq.college.service.UserDetailsServiceImpl
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class ApplicationConfig(private val userDetailsService: UserDetailsServiceImpl) {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	fun objectMapper(): ObjectMapper = ObjectMapper()
		.registerModule(
			KotlinModule.Builder()
				.withReflectionCacheSize(512)
				.configure(KotlinFeature.NullToEmptyCollection, false)
				.configure(KotlinFeature.NullToEmptyMap, false)
				.configure(KotlinFeature.NullIsSameAsDefault, false)
				.configure(KotlinFeature.SingletonSupport, false)
				.configure(KotlinFeature.StrictNullChecks, false)
				.build()
		).registerModule(JavaTimeModule())

	@Bean
	fun authenticationProvider(): AuthenticationProvider {
		val authProvider = DaoAuthenticationProvider()
		authProvider.setUserDetailsService(this.userDetailsService)
		authProvider.setPasswordEncoder(this.passwordEncoder())
		return authProvider
	}

	@Bean
	fun authenticationManager(config: AuthenticationConfiguration) = config.authenticationManager!!

	@Bean
	fun passwordEncoder() = BCryptPasswordEncoder()
}
