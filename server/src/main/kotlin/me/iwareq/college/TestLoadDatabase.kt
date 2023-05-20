package me.iwareq.college

import me.iwareq.college.model.Specialty
import me.iwareq.college.model.User
import me.iwareq.college.service.SpecialtyService
import me.iwareq.college.service.UserService
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class TestLoadDatabase(private val passwordEncoder: PasswordEncoder) {

	private val specialtyDescription: String = """
		Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore 
		magna aliqua. Orci a scelerisque purus semper eget. Felis eget nunc lobortis mattis aliquam faucibus. Eu augue 
		ut lectus arcu bibendum at varius vel. Id semper risus in hendrerit gravida rutrum quisque non. Hac habitasse 
		platea dictumst quisque sagittis purus sit. Proin fermentum leo vel orci porta non. Et tortor consequat id porta 
		nibh venenatis cras sed felis. Tincidunt nunc pulvinar sapien et ligula ullamcorper. Enim eu turpis egestas 
		pretium aenean. Cum sociis natoque penatibus et. Auctor eu augue ut lectus arcu bibendum at varius. Imperdiet 
		sed euismod nisi porta lorem. Morbi blandit cursus risus at ultrices mi tempus imperdiet. Eget mi proin sed 
		libero enim sed faucibus turpis in.

		Proin fermentum leo vel orci porta non pulvinar neque laoreet. Mus mauris vitae ultricies leo integer malesuada.
		Ac feugiat sed lectus vestibulum mattis ullamcorper velit sed. Turpis egestas integer eget aliquet nibh praesent.
		liquam malesuada bibendum arcu vitae elementum curabitur vitae. Vel turpis nunc eget lorem dolor sed viverra 
		ipsum. Lobortis scelerisque fermentum dui faucibus in ornare quam. Egestas pretium aenean pharetra magna ac 
		placerat vestibulum lectus. Sapien faucibus et molestie ac feugiat sed lectus. Ornare aenean euismod elementum 
		nisi quis eleifend quam. Tortor pretium viverra suspendisse potenti nullam ac tortor vitae purus. Proin 
		fermentum leo vel orci. Lectus mauris ultrices eros in cursus turpis.
	""".trimIndent()

	@Bean
	fun initUsers(service: UserService) = CommandLineRunner {
		service.addUser(
			User(
				firstName = "Иван",
				lastName = "Иванов",
				email = "ivan.ivanov@mail.ru",
				password = this.passwordEncoder.encode("ivan.ivanov")
			)
		)
		service.addUser(
			User(
				firstName = "Андрей",
				lastName = "Андреев",
				email = "andrey.andreev@mail.ru",
				password = this.passwordEncoder.encode("andrey.andreev")
			)
		)
	}

	@Bean
	fun initSpecialties(service: SpecialtyService) = CommandLineRunner {
		service.addSpecialty(
			Specialty(
				okpdtr = "11.02.15",
				title = "Инфокоммуникационные сети и системы связи",
				description = specialtyDescription
			)
		)
		service.addSpecialty(
			Specialty(
				okpdtr = "09.02.06",
				title = "Сетевое и системное администрирование",
				description = specialtyDescription
			)
		)
		service.addSpecialty(
			Specialty(
				okpdtr = "09.02.07",
				title = "Информационные системы и программирование",
				description = specialtyDescription
			)
		)
		service.addSpecialty(
			Specialty(
				okpdtr = "38.02.01",
				title = "Экономика и бухгалтерский учет",
				description = specialtyDescription
			)
		)
		service.addSpecialty(
			Specialty(
				okpdtr = "10.02.05",
				title = "Обеспечение информационной безопасности автоматизированных систем",
				description = specialtyDescription
			)
		)
		service.addSpecialty(
			Specialty(
				okpdtr = "11.02.12",
				title = "Почтовая связь",
				description = specialtyDescription
			)
		)
	}
}
