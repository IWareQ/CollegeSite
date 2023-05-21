package me.iwareq.college

import me.iwareq.college.model.*
import me.iwareq.college.service.*
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class TestLoadDatabase(
	private val specialtyService: SpecialtyService,
	private val subjectService: SubjectService,
	private val teacherService: TeacherService,
	private val userService: UserService,
	private val studentService: StudentService,
	private val groupService: GroupService,
	private val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

	override fun run(vararg args: String?) {
		// Создание специальностей
		val specialty1 = specialtyService.addSpecialty(
			Specialty(
				okpdtr = "11.02.15",
				title = "Инфокоммуникационные сети и системы связи"
			)
		)

		val specialty2 = specialtyService.addSpecialty(
			Specialty(
				okpdtr = "09.02.06",
				title = "Сетевое и системное администрирование"
			)
		)

		// Создание предметов
		val subject1 = subjectService.addSubject(
			Subject(
				title = "Физическая культура"
			)
		)

		val subject2 = subjectService.addSubject(
			Subject(
				title = "Основы философии"
			)
		)

		val subject3 = subjectService.addSubject(
			Subject(
				title = "Основы проектирования баз данных"
			)
		)

		val subject4 = subjectService.addSubject(
			Subject(
				title = "Элементы высшей математики"
			)
		)

		// Создание учителей
		val teacher1 = teacherService.addTeacher(
			Teacher(
				user = userService.addUser(
					User(
						firstName = "Андрей",
						lastName = "Волков",
						middleName = "Сергеевич",
						email = "andrey.volkov@example.com",
						password = this.passwordEncoder.encode("andrey.volkov"),
						roles = mutableSetOf(Role.TEACHER)
					)
				),
				subjects = mutableSetOf(subject1, subject2)
			)
		)

		val teacher2 = teacherService.addTeacher(
			Teacher(
				user = userService.addUser(
					User(
						firstName = "Наталья",
						lastName = "Кузнецова",
						middleName = "Петровна",
						email = "natalya.kuznetsova@example.com",
						password = this.passwordEncoder.encode("natalya.kuznetsova"),
						roles = mutableSetOf(Role.TEACHER)
					)
				),
				subjects = mutableSetOf(subject3, subject4)
			)
		)

		// Создание студентов
		val student1 = studentService.addStudent(
			Student(
				user = userService.addUser(
					User(
						firstName = "Александр",
						lastName = "Козлов",
						middleName = "Николаевич",
						email = "alexander.kozlov@mail.ru",
						password = this.passwordEncoder.encode("alexander.kozlov")
					)
				),
				specialty = specialty1,
				admissionDate = LocalDate.now(),
				studyForm = StudyForm.FULL_TIME,
				dateOfIssue = LocalDate.now()
			)
		)

		val student2 = studentService.addStudent(
			Student(
				user = userService.addUser(
					User(
						firstName = "Алексей",
						lastName = "Смирнов",
						middleName = "Игоревич",
						email = "alexey.smirnov@example.com",
						password = this.passwordEncoder.encode("alexey.smirnov")
					)
				),
				specialty = specialty1,
				admissionDate = LocalDate.now(),
				studyForm = StudyForm.FULL_TIME,
				dateOfIssue = LocalDate.now()
			)
		)

		val student3 = studentService.addStudent(
			Student(
				user = userService.addUser(
					User(
						firstName = "Екатерина",
						lastName = "Петрова",
						middleName = "Александровна",
						email = "ekaterina.petrova@example.com",
						password = this.passwordEncoder.encode("ekaterina.petrova")
					)
				),
				specialty = specialty2,
				admissionDate = LocalDate.now(),
				studyForm = StudyForm.FULL_TIME,
				dateOfIssue = LocalDate.now()
			)
		)

		val student4 = studentService.addStudent(
			Student(
				user = userService.addUser(
					User(
						firstName = "Михаил",
						lastName = "Сидоров",
						middleName = "Дмитриевич",
						email = "mikhail.sidorov@example.com",
						password = this.passwordEncoder.encode("mikhail.sidorov")
					)
				),
				specialty = specialty2,
				admissionDate = LocalDate.now(),
				studyForm = StudyForm.FULL_TIME,
				dateOfIssue = LocalDate.now()
			)
		)

		// Создание групп
		groupService.addGroup(
			Group(
				title = "ИСПВ-2",
				students = mutableSetOf(student1, student2),
				classLeader = teacher1
			)
		)

		groupService.addGroup(
			Group(
				title = "ИСПВ-3",
				students = mutableSetOf(student3, student4),
				classLeader = teacher2
			)
		)
	}
}
