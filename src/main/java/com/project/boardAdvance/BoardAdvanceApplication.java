package com.project.boardAdvance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class BoardAdvanceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BoardAdvanceApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public HiddenHttpMethodFilter HiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
}
