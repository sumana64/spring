package com.xworkz.max.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.stereotype.Service;

import com.xworkz.max.dto.MaxDto;

public interface MaxService {
	
	     public Set<ConstraintViolation<MaxDto>> onSave(MaxDto dto);
	     
	     public List<MaxDto> findAll();
	     
	     public MaxDto findById(int id);
	     
	     public List<MaxDto> findByEmail(String email);
	     
	     public boolean deleteById(int id);
	     
	     public boolean onUpdate(MaxDto dto);
	

}
