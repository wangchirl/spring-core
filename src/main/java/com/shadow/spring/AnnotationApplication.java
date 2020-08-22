package com.shadow.spring;

import com.shadow.spring.config.AnnotationConfig;
import com.shadow.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 * 1、基于注解的方式
 *  > 定义配置类 @Configuration
 *  > @Bean注解的使用
 */
public class AnnotationApplication {

	public static void main(String[] args) {

		// 0、代替1/2/3的操作
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AnnotationConfig.class);

		// 1、工厂
		//AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		// 2、加载配置类
		//ac.register(MyConfig.class);
		// 3、刷新容器
		//ac.refresh();

		// 4、获取bean
		AnnotationConfig annotationConfig = (AnnotationConfig) ac.getBean("annotationConfig"); // class com.shadow.spring.config.AnnotationConfig$$EnhancerBySpringCGLIB$$5887f5eb
		UserService userService = (UserService) ac.getBean("userService"); // class com.shadow.spring.service.UserService

		System.out.println(annotationConfig.getClass());
		System.out.println(userService.getClass());

		userService.hello();

	}
}
