package com.xworkz.westSide.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("com.xworkz")
@Configuration
public class WestSideConfiguration {

	public WestSideConfiguration() {
		System.out.println("configuration object");
	}

	@Bean
	public ViewResolver ViewResolver() {
		System.out.println("viewresolver object is created");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		return resolver;

	}
	@Bean
	public LocalContainerEntityManagerFactoryBean Bean() {

		System.out.println("local factory created");
		LocalContainerEntityManagerFactoryBean Icemf = new LocalContainerEntityManagerFactoryBean();
		System.out.println("local entity manager factory bean created");
		System.out.println(Icemf);
		return Icemf;

	}
	
}