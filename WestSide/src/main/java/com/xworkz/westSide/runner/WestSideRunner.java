package com.xworkz.westSide.runner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.westSide.configuration.WestSideConfiguration;

public class WestSideRunner {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WestSideConfiguration.class);

		int count = context.getBeanDefinitionCount();

		System.out.println(count);

		String[] names = context.getBeanDefinitionNames();

		for (String beanName : names) {

			System.out.println(beanName);
		}

	}

}
