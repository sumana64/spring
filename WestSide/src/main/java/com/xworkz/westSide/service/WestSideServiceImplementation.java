package com.xworkz.westSide.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.xworkz.entity.WestSideEntity;
import com.xworkz.westSide.dto.WestSideDto;
import com.xworkz.westSide.repository.WestSideRepository;

@Service
public class WestSideServiceImplementation implements WestSideService {

	@Autowired
	WestSideRepository repo; // to achieve loose coupling we use repository class if we use implementation

	public WestSideServiceImplementation() {
		System.out.println("service Implementation object is created");
	}

	@Override
	public Set<ConstraintViolation<WestSideDto>> onSave(WestSideDto dto) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();//validation is class consist of static methods which returns vlidation factory
    Validator valid   = factory.getValidator();//it checks the constraint to which the properties are addded
    Set<ConstraintViolation<WestSideDto>> voilations = valid.validate(dto);
	if(voilations.isEmpty()) {
		repo.onSave(dto);
		System.out.println("dto is valid successfully");
	}else {
		System.out.println("voilation are present" + voilations);
		return voilations;
	}
    return voilations;
	}
		/*if (dto != null) {
			System.out.println("this is save method in service");
			System.out.println(dto);
			boolean save = repo.onSave(dto);
			if (save != false) {

				return true;
			} else {

				return false;
			}

		} else {

			System.out.println("dto is not null");
		}
		return false;
	}*/

	@Override
	public List<WestSideDto> findAll() {
		System.out.println("this is finAll method in service");
	    List<WestSideEntity> entity = repo.findAll();
		System.out.println(entity);
		List<WestSideDto> dtoList = new ArrayList<WestSideDto>();
		
		for (WestSideEntity en : entity) {
			WestSideDto dto = new WestSideDto();
			BeanUtils.copyProperties(en, dto);
			dtoList.add(dto);
			System.out.println("dto in service " + dto);
		}
		
		System.out.println("dtoList" + dtoList);
		return dtoList;
	}

	@Override
	public WestSideDto findById(int id) {
		WestSideDto dto = new WestSideDto();
		if(id!=0) {	
	     WestSideEntity entity = repo.findById(id);
		 System.out.println("id is valid" + entity);	
		if(entity!=null) {
			BeanUtils.copyProperties(entity, dto);
			System.out.println("dto in service");
			System.out.println("entiy is not null");
			System.out.println(dto);
			
		}else {
			System.out.println("entity is null");
		}
		}else {
			
			System.out.println("id is not valid");
		}
		
		return dto;
	}

	@Override
	public List<WestSideDto> findByUserName(String userName) {
		WestSideDto dto = new WestSideDto();
		List<WestSideDto> dtoList = new ArrayList<WestSideDto>();
		if(userName!=null) {
			List<WestSideEntity> entity=repo.findByUserName(userName);
			System.out.println("name in service method" + entity);
			System.out.println("name is not null");
			if(entity!=null) {
		          for (WestSideEntity en : entity) {
					System.out.println(en);
					BeanUtils.copyProperties(en, dto);
					dtoList.add(dto);
				}
			}else {
				
				System.out.println("entity is null");
			}
		}else {
			System.out.println("name is null");
		}
		System.out.println(dtoList);
		return dtoList;
	}

	@Override
	public List<WestSideDto> findByAddress(String address) {
		WestSideDto dto = new WestSideDto();
		List<WestSideDto> dtoList = new ArrayList<WestSideDto>();
		if(address!=null) {
			List<WestSideEntity> entity=repo.findByUserName(address);
			System.out.println("name in service method" + entity);
			System.out.println("name is not null");
			if(entity!=null) {
		          for (WestSideEntity en : entity) {
					System.out.println(en);
					BeanUtils.copyProperties(en, dto);
					dtoList.add(dto);
				}
			}else {
				
				System.out.println("entity is null");
			}
		}else {
			System.out.println("name is null");
		}
		System.out.println(dtoList);
		return dtoList;
	}

	@Override
	public List<WestSideDto> findByEmail(String email) {
		WestSideDto dto = new WestSideDto();
		List<WestSideDto> dtoList = new ArrayList<WestSideDto>();
		if(email!=null) {
			List<WestSideEntity> entity=repo.findByUserName(email);
			System.out.println("name in service method" + entity);
			System.out.println("name is not null");
			if(entity!=null) {
		          for (WestSideEntity en : entity) {
					System.out.println(en);
					BeanUtils.copyProperties(en, dto);
					dtoList.add(dto);
				}
			}else {
				
				System.out.println("entity is null");
			}
		}else {
			System.out.println("name is null");
		}
		System.out.println(dtoList);
		return dtoList;
	}

	@Override
	public List<WestSideDto> findByPhoneNo(String phoneNo) {
		WestSideDto dto = new WestSideDto();
		List<WestSideDto> dtoList = new ArrayList<WestSideDto>();
		if(phoneNo!=null) {
			List<WestSideEntity> entity=repo.findByUserName(phoneNo);
			System.out.println("name in service method" + entity);
			System.out.println("name is not null");
			if(entity!=null) {
		          for (WestSideEntity en : entity) {
					System.out.println(en);
					BeanUtils.copyProperties(en, dto);
					dtoList.add(dto);
				}
			}else {
				
				System.out.println("entity is null");
			}
		}else {
			System.out.println("name is null");
		}
		System.out.println(dtoList);
		return dtoList;
		
	}

	@Override
	public boolean deleteByid(int id) {
		boolean delete = false;
		if(id!=0) {
			delete=repo.deleteById(id);
		}
		if(delete!=true) {
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public List<WestSideDto> DeleteByUserName(String userName) {
		WestSideDto dto = new WestSideDto();
		List<WestSideDto> dtoList = new ArrayList<WestSideDto>();
		if(userName!=null) {
			List<WestSideEntity> entity=repo.deleteByName(userName);
			System.out.println("name in service method" + entity);
			System.out.println("name is not null");
			if(entity!=null) {
		          for (WestSideEntity en : entity) {
					System.out.println(en);
					BeanUtils.copyProperties(en, dto);
					dtoList.add(dto);
				}
			}else {
				
				System.out.println("entity is null");
			}
		}else {
			System.out.println("name is null");
		}
		System.out.println(dtoList);
		return dtoList;
	}

	@Override
	public boolean onUpdate(WestSideDto dto) {
	System.out.println("this is service update method");
	boolean update = false;
	if(dto!=null) {
	  update  = repo.onUpdate(dto);
		
	}else {
		
		System.out.println("dto is not null");
	}
	if(update==true) {
	return true;
	}else {
		return false;
	}
	}	
	
}
