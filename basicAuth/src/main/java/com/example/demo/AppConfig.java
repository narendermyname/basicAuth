/**
 * 
 */
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ntanwa
 *
 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private RequestInterceptor reqIntercptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(reqIntercptor).addPathPatterns("/api/v1/**");
	}
}
