package com.shadow.spring.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 */
@Configuration
public class DynamicDataSourceConfig {

	@Bean
	public DynamicDataSource dynamicDataSource(){
		return new DynamicDataSource();
	}

}
