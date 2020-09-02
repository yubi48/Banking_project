package com.rab3tech.security.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
public class PasswordEncoderService {

	@Bean
	public BCryptPasswordEncoder passwordEncorder() {
		return new BCryptPasswordEncoder();
	}
}
