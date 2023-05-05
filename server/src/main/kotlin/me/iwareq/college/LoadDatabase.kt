package me.iwareq.college

import me.iwareq.college.model.User
import me.iwareq.college.service.UserService
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LoadDatabase {

	@Bean
	fun initDatabase(service: UserService) = CommandLineRunner {
		service.addUser(User(firstname = "Иван", lastname = "Иванов"))
		service.addUser(User(firstname = "Андрей", lastname = "Андреев"))
	}
}
