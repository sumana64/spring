package com.xworkz.max.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@ComponentScan("com.xworkz")
@Configuration
public class MaxConfiguration {
	
	  public MaxConfiguration() {
		  
		  System.out.println("max config object is created");
	  }
	  
	  @Bean
	  public ViewResolver ViewResolver() {
		 System.out.println("view resolver object is created");
		 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		 resolver.setSuffix(".jsp");
		 return resolver; 
		    
	  }
	  
	  @Bean
	  public LocalContainerEntityManagerFactoryBean Bean() {
		  System.out.println("local container created");
		  LocalContainerEntityManagerFactoryBean lcemf = new LocalContainerEntityManagerFactoryBean();
		  System.out.println("entity manager factory object is created");
		return lcemf;
		  
		  
		  
		  
	  }

}
