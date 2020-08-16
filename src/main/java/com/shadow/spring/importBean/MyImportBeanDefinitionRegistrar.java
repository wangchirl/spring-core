package com.shadow.spring.importBean;

import com.shadow.spring.importBean.beans.ImportBeanDefinitionRegistrarDemo;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//指定bean定义信息（包括bean的类型、作用域...）
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(ImportBeanDefinitionRegistrarDemo.class);
		//注册一个bean指定bean名字（id）
		String beanName = ImportBeanDefinitionRegistrarDemo.class.getSimpleName().substring(0,1).toLowerCase() + ImportBeanDefinitionRegistrarDemo.class.getSimpleName().substring(1);
		registry.registerBeanDefinition(beanName,rootBeanDefinition);
	}
}
