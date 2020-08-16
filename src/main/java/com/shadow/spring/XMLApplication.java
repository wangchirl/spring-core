package com.shadow.spring;

import com.shadow.spring.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 * 1、基于XML配置的方式
 *  > 1 定位配置资源
 *  > 2 初始化 beanFactory
 *  > 3 初始化资源读取器
 *  > 4 加载资源
 *  > 5 实例化 bean
 */
public class XMLApplication {
	public static void main(String[] args) {

		// 1、资源
		Resource resource = new ClassPathResource("spring-context.xml");
		// 2、工厂
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// 3、资源读取器
		BeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		// 4、加载资源
		reader.loadBeanDefinitions(resource);

		// 5、获取bean
		UserService userService = (UserService) factory.getBean("userService");

		userService.hello();

	}
}
