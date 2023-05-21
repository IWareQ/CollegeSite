package me.iwareq.keygenerator

import java.security.SecureRandom

private const val CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"

fun main() {
	println("Secret key for JWT: " + generateKey(64))
	println("Password for Admin: " + generateKey(16))
}

private fun generateKey(length: Int): String {
	val random = SecureRandom()
	val sb = StringBuilder(length)
	repeat(length) {
		val randomIndex = random.nextInt(CHARACTERS.length)
		sb.append(CHARACTERS[randomIndex])
	}

	return sb.toString()
}
