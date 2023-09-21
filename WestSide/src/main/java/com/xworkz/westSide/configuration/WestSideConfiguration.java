package com.xworkz.westSide.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan("com.xworkz")
@Configuration
public class WestSideConfiguration {

	public WestSideConfiguration() {
		System.out.println("configuration object");
	}

}
