package me.iwareq.college.repository

import me.iwareq.college.model.Specialty
import org.springframework.data.jpa.repository.JpaRepository

interface SpecialtyRepository : JpaRepository<Specialty, Long>
