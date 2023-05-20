package me.iwareq.college.service

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.security.Key
import java.util.*

@Service
class SecurityService {

	@Value("\${spring.security.jwt.secret-key}")
	private lateinit var secretKey: String

	@Value("\${spring.security.jwt.expiration}")
	private var expiration: Long = -1

	fun extractEmail(token: String): String? = this.extractClaim(token) { it.subject }

	fun <T> extractClaim(token: String, claimsResolver: (claims: Claims) -> T): T {
		val claims = this.extractAllClaims(token)
		return claimsResolver(claims)
	}

	fun generateToken(extraClaims: Map<String, Any?> = mapOf(), userDetails: UserDetails): String {
		return Jwts
			.builder()
			.setClaims(extraClaims)
			.setSubject(userDetails.username)
			.setIssuedAt(Date())
			.setExpiration(Date(System.currentTimeMillis() + this.expiration))
			.signWith(getSigningKey(), SignatureAlgorithm.HS256)
			.compact()
	}

	fun isTokenValid(token: String, userDetails: UserDetails): Boolean {
		val email = this.extractEmail(token)
		return email == userDetails.username && !this.isTokenExpired(token)
	}

	private fun isTokenExpired(token: String) = this.extractExpiration(token).before(Date())

	private fun extractExpiration(token: String): Date = this.extractClaim(token) { it.expiration }

	private fun extractAllClaims(token: String): Claims {
		return Jwts
			.parserBuilder()
			.setSigningKey(this.getSigningKey())
			.build()
			.parseClaimsJws(token)
			.body
	}

	private fun getSigningKey(): Key {
		val keyBytes = Decoders.BASE64.decode(this.secretKey)
		return Keys.hmacShaKeyFor(keyBytes)
	}
}
