package com.xworkz.westSide.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.westSide.dto.WestSideDto;
import com.xworkz.westSide.service.WestSideService;
import com.xworkz.westSide.service.WestSideServiceImplementation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class WestSideController {

	@Autowired
	WestSideService service;

	public WestSideController() {

		System.out.println("controller object");

	}

	@PostMapping("/register")
	public String onSave(@ModelAttribute WestSideDto dto, Model model) {
		model.addAttribute("dto", dto);
		Set<ConstraintViolation<WestSideDto>> voilation=service.onSave(dto);
		if(voilation.isEmpty()) {
			model.addAttribute("message","No voilation it is valid");
		return "Success";
		}else {
			model.addAttribute("voilation", voilation);
		    return "Register";
		}
	}

	@GetMapping("/findAll")
	public String findAll(Model model) {
		List<WestSideDto> dto = service.findAll();
		model.addAttribute("dto1", dto);
		log.info(dto.toString());
		return "FindAll";

	}

	@GetMapping("/findById")
	public String findById(int id, Model model) {
		WestSideDto dto = service.findById(id);
		model.addAttribute("dto", dto);
		return "FindById";

	}

	@GetMapping("/findByName")
	public String findByUserName(String userName, Model model) {
		List<WestSideDto> dto = service.findByUserName(userName);
		model.addAttribute("dto", dto);
		return "FindByName";

	}

	@GetMapping("/findByAddress")
	public String findByAddress(String address, Model model) {
		List<WestSideDto> dto = service.findByAddress(address);
		model.addAttribute("dto", dto);
		return "FindByAddress";

	}

	@GetMapping("/findByEmail")
	public String findByEmail(String email, Model model) {
		List<WestSideDto> dto = service.findByEmail(email);
		model.addAttribute("dto", dto);
		return "FindByEmail";

	}

	@GetMapping("/findByPhoneNo")
	public String findByPhoneNo(String email, Model model) {
		List<WestSideDto> dto = service.findByPhoneNo(email);
		model.addAttribute("dto", dto);
		return "FindByPhoneNo";

	}

	@GetMapping("/deleteById")
	public String deleteById(@RequestParam int id, Model model) {

		System.out.println("this is delete method");
		System.out.println(id);
		boolean delete = service.deleteByid(id);
		if (delete == true) {

			model.addAttribute("success", "record deleted successfully");
			return "FindAll";

		} else {

			model.addAttribute("fail", "record not deleted successfully");
			return "FindAll";
		}

	}

	@GetMapping("deleteByName")
	public String deleteByName(@RequestParam String userName, Model model) {

		System.out.println("this is delete method by name");
		System.out.println(userName);

		List<WestSideDto> delete = service.DeleteByUserName(userName);
		if (delete != null) {
			model.addAttribute("success", "record delete successfully");
			return "FindByName";

		} else {

			model.addAttribute("fail", "record not found successfully");
			return "FindByName";
		}

	}

	@GetMapping("update")
	public String update(@RequestParam int id, Model model) {
		System.out.println("id" + id);
		WestSideDto dto = service.findById(id);
		if (dto != null) {
			model.addAttribute("dto", dto);
			return "update";
		} else {
			model.addAttribute("message", "dto is null");
			return "update";
		}

	}
	

	@PostMapping("update")
	public String updateById(@ModelAttribute WestSideDto dto, Model model) {
		System.out.println("this upadte dto" + dto);
		boolean update = service.onUpdate(dto);
		if(update!=false) {
			model.addAttribute("updatemessage", "update is done");
			return "FindAll";
			}else {
				model.addAttribute("updatemessage", "update is not done");
				return "update";
			}
		
	}
	
	
	


}
