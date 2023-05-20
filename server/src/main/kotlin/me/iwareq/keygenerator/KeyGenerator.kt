package me.iwareq.keygenerator

import java.security.SecureRandom

private const val CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"

private const val KEY_LENGTH = 64

fun main() {
	val random = SecureRandom()
	val sb = StringBuilder(KEY_LENGTH)
	for (i in 0 until KEY_LENGTH) {
		val randomIndex = random.nextInt(CHARACTERS.length)
		sb.append(CHARACTERS[randomIndex])
	}

	println("Random key: $sb")
}
