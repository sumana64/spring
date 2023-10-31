package com.xworkz.westSide.repository;

import java.util.List;

import com.xworkz.entity.WestSideEntity;
import com.xworkz.westSide.dto.WestSideDto;

public interface WestSideRepository {
	
	 public boolean onSave(WestSideDto dto);
	 
	 public List<WestSideEntity> findAll();
	 
	 public WestSideEntity findById(int id);
	 
	 public List<WestSideEntity> findByUserName(String userName);
	 
	 public List<WestSideEntity> findByAddress(String address);

	 public List<WestSideEntity> findByEmail(String email);

	 public List<WestSideEntity> findByPhoneNo(String phoneNo);
	 
	 public boolean deleteById(int id);
	 
	 public List<WestSideEntity> deleteByName(String userName);
	 
	 public boolean onUpdate(WestSideDto dto);
	 
	

}
