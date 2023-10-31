package com.xworkz.max.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.max.dto.MaxDto;
import com.xworkz.max.service.MaxService;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

@Controller
@RequestMapping("/")
public class MaxController {
        
	    @Autowired
	    MaxService service;
	    
	    public MaxController() {
	    	
	    	System.out.println("controller object is created");
	    }
	    
	    @PostMapping("/register")
	    public String onSave(@ModelAttribute MaxDto dto, Model model) {
		System.out.println("this is dto in controller");
	    model.addAttribute("dto", dto);
	    Set<ConstraintViolation<MaxDto>> voilation = service.onSave(dto);
	    if(voilation.isEmpty()) {
	    	model.addAttribute("message", "no voilation");
	    return "Success";
	    }else {
	    	model.addAttribute("voilation", voilation);
	    	return "Register";
	    }
	   
	    }
	    
	    @GetMapping("/findAll")
	    public String findAll(Model model) {
		List<MaxDto> dto =  service.findAll();
	    model.addAttribute("dto", dto);	
	    System.out.println(dto);	
	    return "FindAll";	
	    	
	    }
	    
	    @GetMapping("/findById")
	    public String findById(@RequestParam int id,Model model) {
	    System.out.println("findById in controller");	
	    MaxDto  dto = service.findById(id);	
	    System.out.println(dto);
	    model.addAttribute("dto", dto);
	    return "FindById";	
	    }
	    
	    @GetMapping("/findByEmail")
	    public String findByEmail(@RequestParam String email,Model model) {
		System.out.println("findByEmail in controller");	
	    List<MaxDto> dto = service.findByEmail(email);	
	    System.out.println(dto);
	    model.addAttribute("dto", dto);
	    return "FindByEmail";
	    		
	    }
	    
	    @GetMapping("/deleteById")
	    public String deleteById(@RequestParam int id,Model model) {
		System.out.println("this id delete method in controller");
	     boolean delete = service.deleteById(id);
	     if(delete==true) {
	    	 
	    	 model.addAttribute("success", "deleted successfully");
	    	 return "FindAll";
	     }else {
	    	 
	    	  model.addAttribute("fail", "deleted unsuccessfully");
	    	  return "FindAll";
	     }
	    	
	    	
	    	
	    }
	    
	    @GetMapping("update")
	    public String update(@RequestParam int id,Model model) {
			System.out.println(id);
		  MaxDto dto=service.findById(id);
	    	if(dto!=null) {
	    		System.out.println("dto is not null");
	    		model.addAttribute("dto", dto);
	    		return "update";
	    		
	    	}else {
	    		
	    		System.out.println("dto is null");
	    		model.addAttribute("message", "dto is null");
	    		return "update";
	    		
	    	}
	    	
	    	
	    }
	    
	    @PostMapping("update")
	    public String onUpdate(@ModelAttribute MaxDto dto,Model model) {
	    	boolean update = false;
			System.out.println("this is update method in the controller");
	        update = service.onUpdate(dto);
	    	if(update==true) {
	    		System.out.println("update is completed");
	    		model.addAttribute("updatedMessage","update is done");
	    		return "FindAll";
	    	}else {
	    		System.out.println("update is incomplete");
	    		model.addAttribute("updatedMessage", "update is not done");
	    		return "update";
	    	}
	    	
	    
	    	
	    }
	    
	    @GetMapping("/updateByEmail")
	    public String updateByEmail(@RequestParam String email,Model model) {
	    List<MaxDto> dto = service.findByEmail(email);
			   if(dto!=null) {
				   
				   model.addAttribute("dto", dto);
				   return "updateByEmail";
			   }else {
				   model.addAttribute("message", "dto is not found");
				   return "updateByEmail";
			   }	
	    }

}
