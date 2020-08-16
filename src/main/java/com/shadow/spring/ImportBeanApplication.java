package com.shadow.spring;

import com.shadow.spring.importBean.ImportConfig;
import com.shadow.spring.importBean.beans.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 * 注册 bean 的方式
 * 1、xml
 * 		> <bean id="" class=""/>
 * 2、javaConfig
 * 		> @Configuration
 * 		> @Bean
 * 3、@Import
 *      > 任意类 ：beanName 为 全类名
 * 		> org.springframework.context.annotation.ImportSelector ： beanName 为 全类名
 * 		> org.springframework.context.annotation.ImportBeanDefinitionRegistrar ：beanName 可指定
 * 4、@ComponentScan
 * 		> @Component
 * 		> @Controller
 * 		> @Service
 * 		> @Repository
 */
public class ImportBeanApplication {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ImportConfig.class);

		BeanDemo beanDemo = (BeanDemo) ac.getBean("beanDemo");
		ComponentDemo componentDemo = (ComponentDemo) ac.getBean("componentDemo");
		XmlDemo xmlDemo = (XmlDemo) ac.getBean("xmlDemo");
		ImportDemo importDemo = (ImportDemo) ac.getBean("com.shadow.spring.importBean.beans.ImportDemo");
		ImportSelectorDemo importSelectorDemo = (ImportSelectorDemo) ac.getBean("com.shadow.spring.importBean.beans.ImportSelectorDemo");
		ImportBeanDefinitionRegistrarDemo importBeanDefinitionRegistrarDemo = (ImportBeanDefinitionRegistrarDemo) ac.getBean("importBeanDefinitionRegistrarDemo");

		System.out.println(beanDemo);
		System.out.println(componentDemo);
		System.out.println(xmlDemo);
		System.out.println(importDemo);
		System.out.println(importSelectorDemo);
		System.out.println(importBeanDefinitionRegistrarDemo);

	}
}
