package com.shadow.spring.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 */
@Configuration
public class DynamicDataSourceConfiguration {

	@Bean
	public Marker enableConfigDynamicMarker(){
		return new Marker();
	}

	class Marker {

	}
}
