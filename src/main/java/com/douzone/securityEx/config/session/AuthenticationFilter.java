package com.douzone.securityEx.config.session;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.douzone.securityEx.config.auth.PrincipalDetails;
import com.douzone.securityEx.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

/*
 *  스프링 시큐리티에서 UsernamePasswordAuthenticationFilter 가 있음
 *  /login 요청해서 username, password 전송하면 (post)
 *  UsernamePasswordAuthenticationFilter 동작을 한다.
 * */
@RequiredArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	private AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager2) {
		this.authenticationManager = authenticationManager2;
	}

	// /login 요청을 하면 로그인 시도를 위해서 실행되는 함수.
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("AuthenticationFilter : 로그인 시도중");

		// 1. username, password를 받아서, json데이터를 파싱해준다.
		ObjectMapper om = new ObjectMapper();
		User user = null;
		try {
			user = om.readValue(request.getInputStream(), User.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("AuthenticationFilter : " + user);

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				user.getUsername(), user.getPassword());

		// PrincipalDetailsService is Run
		Authentication authentication = authenticationManager.authenticate(authenticationToken);

		System.out.println("AuthenticationFilter2");

		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		System.out.println("로그인 완료됨 ? : " + principalDetails.getUser().getUsername()); // 로그인이 정상적으로 되었다는 뜻

		return authentication;
	}

	// attemptAuthentication 실행 후 인증이 정상적으로 되었으면 successfulAuthentication함수가 실행됨.
	// JWT토큰을 만들어서 request 요청한 사용자에게 JWT토큰을 response해주면 됨.
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// 4. JWT토큰을 만들어서 응답해주면 됨.
		System.out.println("successfulAuthentication 실행됨 : 인증 완료");

		PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

		// Hash암호 방식, 라이브러리 사용
		String jwtToken = JWT.create().withSubject("instaToken")
				.withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME)) // 만료 시간
				.withClaim("id", principalDetails.getUser().getNo()) // 내가 넣고 싶은 key:value
				.withClaim("username", principalDetails.getUser().getUsername())
				.sign(Algorithm.HMAC512(JwtProperties.SECRET));

		response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);
	}
}