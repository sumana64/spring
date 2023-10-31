package com.xworkz.max.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.entity.MaxEntity;
import com.xworkz.max.dto.MaxDto;
import com.xworkz.max.repository.MaxRepository;

@Service
public class MaxServiceImplementation implements MaxService {
	
	@Autowired
	MaxRepository repo;

	@Override
	public Set<ConstraintViolation<MaxDto>> onSave(MaxDto dto) {
     ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
     Validator validate = factory.getValidator();
     Set<ConstraintViolation<MaxDto>> voilations  = validate.validate(dto);
     if(voilations.isEmpty()) {
    	 repo.onSave(dto);
    	 System.out.println("no voilations data is valid");
     }else {
    	 System.out.println("voilations are present" + voilations);
    	 return voilations;
     }
	return voilations;
	
	}
		/*if(dto!=null) {
			System.out.println("service save method");
			boolean save =repo.onSave(dto);
			System.out.println("dto is not null");
			return true;
		}else {
			System.out.println("dto is null");
			return false;
		}
		
	}*/

	@Override
	public List<MaxDto> findAll() {
		System.out.println("this find all method in service");
		List<MaxEntity> entity = repo.findAll();
		System.out.println(entity);
		List<MaxDto> dtoList = new ArrayList<MaxDto>();
		for (MaxEntity en : entity) {
			MaxDto dto = new MaxDto();
			BeanUtils.copyProperties(en, dto);
			dtoList.add(dto);
			System.out.println("dto in list" + dto);
		}
		
		System.out.println("dto list" + dtoList);
		return dtoList;
	}

	@Override
	public MaxDto findById(int id) {
		MaxDto dto = new MaxDto();
		if(id!=0) {
			System.out.println("findBy id in service");
			MaxEntity entity  =  repo.findById(id);
			System.out.println(entity);
			if(entity!=null) {
				BeanUtils.copyProperties(entity, dto);
				System.out.println("dto in service to find id");
				System.out.println(dto);
			}else {
				
				System.out.println("entity is null");
			}
			}else {
			System.out.println("id is null");
		}
		return dto;
	}

	@Override
	public List<MaxDto> findByEmail(String email) {
		MaxDto dto = new MaxDto();
		List<MaxDto> dtoList = new ArrayList<MaxDto>(); 
        if(email!=null) {
		System.out.println("findByEmailid in service");
		List<MaxEntity> entityList = repo.findByEmail(email);
		System.out.println(entityList);
		if(entityList!= null) {
			  for (MaxEntity entity : entityList) {
			      BeanUtils.copyProperties(entity, dto);
			      dtoList.add(dto);
			  }
			  	
			}else {
				
				System.out.println("entitylist is null");
			}
			
		}else {
			System.out.println("email is null");
		}
		System.out.println(dtoList);
		return dtoList ;
	}

	@Override
	public boolean deleteById(int id) {
		boolean delete = false;
		if(id!=0) {
			System.out.println("id is found");
		delete =repo.deleteById(id);
		return true;
		}else {
			System.out.println("id is not found");
		}
		return false;
	}
@Override
	public boolean onUpdate(MaxDto dto) {
		System.out.println("updateByid in service");
		if(dto!=null) {
	    System.out.println("dto is not null");
	    boolean update = repo.onUpdate(dto);
	          return true;
		}
		return false;
		
	}

}
