package com.shadow.spring.config;

import com.shadow.spring.lifecycle.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 */
@Configuration
@ImportResource("spring-context-liftcycle.xml") // 引入xml配置
@ComponentScan("com.shadow.spring.lifecycle") // 扫描路径
public class LifecycleConfig {

}
