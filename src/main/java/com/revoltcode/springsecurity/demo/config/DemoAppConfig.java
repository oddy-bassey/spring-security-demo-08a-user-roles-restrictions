package com.revoltcode.springsecurity.demo.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.revoltcode.springsecurity.demo")
public class DemoAppConfig {

	//Define a bean for a view resolver
	@Bean
	public ViewResolver viewResolver(){
		
		InternalResourceViewResolver webViewResolver = new InternalResourceViewResolver();
		webViewResolver.setPrefix("/WEB-INF/view/");
		webViewResolver.setSuffix(".jsp");
		
		return webViewResolver;
	}
}
