1、Spring基于xml方式的使用
2、Spring基于JavaConfig方式的使用
3、bean的生命周期
4、注入bean的方式

1、基于XML配置的方式
 > 1 定位配置资源
 > 2 初始化 beanFactory
 > 3 初始化资源读取器
 > 4 加载资源
 > 5 实例化 bean
2、基于注解的方式
 > 定义配置类 @Configuration
 > @Bean注解的使用

3、bean的生命周期 
 * <p>Bean factory implementations should support the standard bean lifecycle interfaces
 * as far as possible. The full set of initialization methods and their standard order is:
 * <ol>
 * <li>BeanNameAware's {@code setBeanName}
 * <li>BeanClassLoaderAware's {@code setBeanClassLoader}
 * <li>BeanFactoryAware's {@code setBeanFactory}
 * <li>EnvironmentAware's {@code setEnvironment}
 * <li>EmbeddedValueResolverAware's {@code setEmbeddedValueResolver}
 * <li>ResourceLoaderAware's {@code setResourceLoader}
 * (only applicable when running in an application context)
 * <li>ApplicationEventPublisherAware's {@code setApplicationEventPublisher}
 * (only applicable when running in an application context)
 * <li>MessageSourceAware's {@code setMessageSource}
 * (only applicable when running in an application context)
 * <li>ApplicationContextAware's {@code setApplicationContext}
 * (only applicable when running in an application context)
 * <li>ServletContextAware's {@code setServletContext}
 * (only applicable when running in a web application context)
 * <li>{@code postProcessBeforeInitialization} methods of BeanPostProcessors
 * <li>InitializingBean's {@code afterPropertiesSet}
 * <li>a custom init-method definition
 * <li>{@code postProcessAfterInitialization} methods of BeanPostProcessors
 * </ol>
 *
 * <p>On shutdown of a bean factory, the following lifecycle methods apply:
 * <ol>
 * <li>{@code postProcessBeforeDestruction} methods of DestructionAwareBeanPostProcessors
 * <li>DisposableBean's {@code destroy}
 * <li>a custom destroy-method definition
 bean的创建过程流程图：
 @link resources:类加载及对象创建过程.png
 
 1、模拟 bean 的生命周期 => Person.class
 
 	> 利用 BeanFactoryPostProcessor 对 BeanDefinition 元信息进行修改
 	> 找到 beanFactory 中的 BeanDefinition 对象
 	> 推断合适的构造方法，利用反射 newInstance 实例化 bean 对象
  	> 对象属性填充 populate
  	> 执行一堆 *Aware 接口的回调方法
  	> bean 后置处理器BeanPostProcessor#postProcessBeforeInitialization 方法
  	> bean 初始化
 		>> @PostConstruct
 		>> afterPropertiesSet
 		>> init-method
 	> bean 后置处理器BeanPostProcessor#postProcessAfterInitialization 方法
 	> 判断是否实现了 DisposableBean 接口，加入到销毁前的 bean集合中，销毁时调用 相关方法
 		>> @PreDestroy
 		>> destroy
 		>> destroy-method
 	> 创建完成，存入到单列池中 singletonObjects 中
 	
4、注册 bean 的方式

    > 1、xml
    		> <bean id="" class=""/>
    > 2、javaConfig
     		> @Configuration
     		> @Bean
    > 3、@Import
          > @Configuration 类
     		> org.springframework.context.annotation.ImportSelector ： beanName 为 全类名
     		> org.springframework.context.annotation.ImportBeanDefinitionRegistrar ：beanName 可指定
            > 普通的 component classes 全类名
    > 4、@ComponentScan
     		> @Component
     		> @Controller
     		> @Service
     		> @Repository
     		
5、基于注解和基于XML配置的Spring bean在创建时机上存在的唯一不同之处：

      基于XML配置的方式，bean 对象的创建是在程序首次从工厂中获取该对象时才创建的
      基于注解配置的方式，bean 对象的创建是在注解处理器解析相应的@Bean注解时调用了该注解所修饰的方法
      当该方法执行后，相应的对象自然就已经被创建出来了，这时，Spring就会将该对象纳入到工厂的管理范围之内
      当我们首次尝试从工厂中获取到该bean对象时，这时该bean对象实际上已经完成了创建并被纳入到工厂单例池中
