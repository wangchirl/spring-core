package com.shadow.spring.importBean;

import com.shadow.spring.importBean.beans.BeanDemo;
import com.shadow.spring.importBean.beans.ImportDemo;
import org.springframework.context.annotation.*;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 */
@Configuration
@ComponentScan("com.shadow.spring.importBean.beans")
@ImportResource("spring-context-import.xml")
@Import({ImportDemo.class, MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class ImportConfig {

	@Bean
	public BeanDemo beanDemo(){
		return new BeanDemo();
	}

}
