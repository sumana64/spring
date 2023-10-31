package com.xworkz.max.repository;

import java.util.List;

import com.xworkz.entity.MaxEntity;
import com.xworkz.max.dto.MaxDto;

public interface MaxRepository {
	
	public boolean onSave(MaxDto dto);
	
	public List<MaxEntity> findAll();
	
	public MaxEntity findById(int id);
	
	public List<MaxEntity> findByEmail(String email);
	
	public boolean deleteById(int id);
	
	public boolean onUpdate(MaxDto dto);

}
