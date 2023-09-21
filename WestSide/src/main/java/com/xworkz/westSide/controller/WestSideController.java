package com.xworkz.westSide.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.westSide.dto.WestSideDto;

@Component
@RequestMapping("/")
public class WestSideController {
	
	           public WestSideController() {
	        	   
	        	   System.out.println("controller object");
	        	   
	           }
	           
	           @PostMapping("/register")
	           public String onSave(@ModelAttribute WestSideDto dto,Model model) {
	        	  System.out.println("dto" + dto); 
	        	  model.addAttribute("dto", dto);
	        	 return "Register.jsp";  
	           }

}
