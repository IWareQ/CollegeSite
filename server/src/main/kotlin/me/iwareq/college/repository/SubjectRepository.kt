package me.iwareq.college.repository

import me.iwareq.college.model.Subject
import org.springframework.data.jpa.repository.JpaRepository

interface SubjectRepository : JpaRepository<Subject, Long>
