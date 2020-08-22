package com.shadow.spring.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 */
@Configuration
@ConditionalOnBean(DynamicDataSourceConfiguration.Marker.class)
@Import({DynamicDataSourceConfig.class})
public class DynamicDataSourceAutoConfiguration {

}
