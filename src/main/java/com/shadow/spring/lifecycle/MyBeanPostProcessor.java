package com.shadow.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("bean 初始化前执行：BeanPostProcessor#BeanPostProcessor#postProcessBeforeInitialization~");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("bean 初始化后执行：BeanPostProcessor#BeanPostProcessor#postProcessAfterInitialization~");
		return bean;
	}
}
