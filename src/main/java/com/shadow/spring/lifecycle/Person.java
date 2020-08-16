package com.shadow.spring.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 */
public class Person implements InitializingBean, BeanNameAware {


	@Autowired
	private Dog dog;


	public Person(){
		System.out.println("实例化 #Constructor~");
	}

	@PostConstruct
	public void postConstruct(){
		System.out.println("初始化 #PostConstruct~");
	}

	public void init() {
		System.out.println("初始化 #init~");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("初始化 #afterPropertiesSet~");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("属性已填充完成 populated~" + dog);
		System.out.println("*Aware接口回调 Aware~");
	}
}
