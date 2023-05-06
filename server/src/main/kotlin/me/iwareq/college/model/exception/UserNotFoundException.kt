package me.iwareq.college.model.exception

class UserNotFoundException(userId: Long) : RuntimeException("User with id: $userId not found")
