package me.iwareq.college.model.exception

class UserNotFoundException(userId: Long) : RuntimeException("Could not find employee $userId")
