package me.iwareq.college.repository

import me.iwareq.college.model.Group
import org.springframework.data.jpa.repository.JpaRepository

interface GroupRepository : JpaRepository<Group, Long>
