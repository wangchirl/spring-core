package com.shadow.spring;

import com.shadow.spring.config.LifecycleConfig;
import com.shadow.spring.lifecycle.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 *  * <p>Bean factory implementations should support the standard bean lifecycle interfaces
 *  * as far as possible. The full set of initialization methods and their standard order is:
 *  * <ol>
 *  * <li>BeanNameAware's {@code setBeanName}
 *  * <li>BeanClassLoaderAware's {@code setBeanClassLoader}
 *  * <li>BeanFactoryAware's {@code setBeanFactory}
 *  * <li>EnvironmentAware's {@code setEnvironment}
 *  * <li>EmbeddedValueResolverAware's {@code setEmbeddedValueResolver}
 *  * <li>ResourceLoaderAware's {@code setResourceLoader}
 *  * (only applicable when running in an application context)
 *  * <li>ApplicationEventPublisherAware's {@code setApplicationEventPublisher}
 *  * (only applicable when running in an application context)
 *  * <li>MessageSourceAware's {@code setMessageSource}
 *  * (only applicable when running in an application context)
 *  * <li>ApplicationContextAware's {@code setApplicationContext}
 *  * (only applicable when running in an application context)
 *  * <li>ServletContextAware's {@code setServletContext}
 *  * (only applicable when running in a web application context)
 *  * <li>{@code postProcessBeforeInitialization} methods of BeanPostProcessors
 *  * <li>InitializingBean's {@code afterPropertiesSet}
 *  * <li>a custom init-method definition
 *  * <li>{@code postProcessAfterInitialization} methods of BeanPostProcessors
 *  * </ol>
 *  *
 *  * <p>On shutdown of a bean factory, the following lifecycle methods apply:
 *  * <ol>
 *  * <li>{@code postProcessBeforeDestruction} methods of DestructionAwareBeanPostProcessors
 *  * <li>DisposableBean's {@code destroy}
 *  * <li>a custom destroy-method definition
 *
 *  bean的创建过程流程图：
 *  @link resources:类加载及对象创建过程.png
 *
 *  1、模拟 bean 的生命周期 => Person.class
 *  	> 利用 BeanFactoryPostProcessor 对 BeanDefinition 元信息进行修改
 *  	> 找到 beanFactory 中的 BeanDefinition 对象
 *  	> 推断合适的构造方法，利用反射 newInstance 实例化 bean 对象
 *   	> 对象属性填充 populate
 *   	> 执行一堆 *Aware 接口的回调方法
 *   	> bean 后置处理器BeanPostProcessor#postProcessBeforeInitialization 方法
 *   	> bean 初始化
 *  		>> @PostConstruct
 *  		>> afterPropertiesSet
 *  		>> init-method
 *  	> bean 后置处理器BeanPostProcessor#postProcessAfterInitialization 方法
 *  	> 判断是否实现了 DisposableBean 接口，加入到销毁前的 bean集合中，销毁时调用 相关方法
 *  		>> @PreDestroy
 *  		>> destroy
 *  		>> destroy-method
 *  	> 创建完成，存入到单列池中 singletonObjects 中
 */
public class BeanLifecycleApplication {
	public static void main(String[] args) {
		// 1、工厂
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleConfig.class);
		// 2、获取bean
		Person person = (Person) ac.getBean("person");
		// 3、输出
		System.out.println(person);

	}
}
