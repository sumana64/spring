package com.xworkz.westSide.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.westSide.dto.WestSideDto;

public interface WestSideService {
	
	  public Set<ConstraintViolation<WestSideDto>> onSave(WestSideDto dto);
	  
	  public List<WestSideDto> findAll();
	  
	  public WestSideDto findById(int id);
	  
	  public List<WestSideDto> findByUserName(String userName);
	  
	  public List<WestSideDto> findByAddress(String address);

	  public List<WestSideDto> findByEmail(String email);

	  public List<WestSideDto> findByPhoneNo(String phoneNo);
	  
	  public boolean deleteByid(int id);
	  
	  public List<WestSideDto> DeleteByUserName(String userName);
	  
	  public boolean onUpdate(WestSideDto dto);

	  


}
