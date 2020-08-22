package com.shadow.spring;

import com.shadow.spring.condition.DynamicDataSource;
import com.shadow.spring.condition.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 * 1、带条件的 bean 注入，Springboot 实现灵活配置的根源，随处可见的 Spring Cloud 组件中的使用
 * 	> @Bean
 * 	> @Conditional
 * 	> @ConditionalOnMissingBean
 * 	> @ConditionalOnMissingClass...
 *
 *	这种方式一般结合的是自动装配来使用
 *
 */
public class ConditionApplication {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);

		DynamicDataSource dynamicDataSource = (DynamicDataSource) ac.getBean("dynamicDataSource");

		System.out.println(dynamicDataSource);

	}
}
