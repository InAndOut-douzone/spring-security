package com.douzone.securityEx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.douzone.securityEx.config.session.AuthenticationFilter;
import com.douzone.securityEx.config.session.AuthorizationFilter;
import com.douzone.securityEx.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CorsConfig corsConfig;
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
			.csrf().disable()
			.addFilter(corsConfig.corsFilter()) // @CrossOrigin(인증X), 시큐리티 필터에 등록 인증(O);
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			
		.and()
			.formLogin().disable()
			.httpBasic().disable()
			.addFilter(new AuthenticationFilter(authenticationManager()))
			.addFilter(new AuthorizationFilter(authenticationManager(), userRepository))
			.authorizeRequests()
			.antMatchers("/api/user").authenticated()
			.antMatchers("/api/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
			.antMatchers("/api/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().permitAll();
	}
}