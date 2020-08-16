package com.shadow.spring.config;

import com.shadow.spring.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 */
@Configuration
public class AnnotationConfig {

	@Bean
	public UserService userService() {
		return new UserService();
	}

}
