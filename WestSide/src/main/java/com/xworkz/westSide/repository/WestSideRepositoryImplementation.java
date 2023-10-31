package com.xworkz.westSide.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.entity.WestSideEntity;
import com.xworkz.westSide.dto.WestSideDto;

@Repository
public class WestSideRepositoryImplementation implements WestSideRepository {
	public WestSideRepositoryImplementation() {
		System.out.println("WestSideRepoImplementation");
	}

	@Autowired
	private EntityManagerFactory factory;

	@Override
	public boolean onSave(WestSideDto dto) {
		System.out.println(" this is westSiderepo and it is started");
		System.out.println(dto);

		WestSideEntity entity = new WestSideEntity();

		entity.setId(dto.getId());
		entity.setUserName(dto.getUserName());
		entity.setEmail(dto.getEmail());
		entity.setPhoneNo(dto.getPhoneNo());
		entity.setPassWord(dto.getPassWord());
		entity.setGender(dto.getGender());
		entity.setAddress(dto.getAddress());
		entity.setPassWord(dto.getPassWord());
		entity.setShoppingFor(dto.getShoppingFor());

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();

		return true;
	}

	@Override
	public List<WestSideEntity> findAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findAll");
		List<WestSideEntity> list = query.getResultList();
		for (WestSideEntity en : list) {
			System.out.println("entity in repo" + en.toString());
		}
		System.out.println("list" + list.toString());
		return list;
	}

	@Override
	public WestSideEntity findById(int id) {
		EntityManager manager = factory.createEntityManager();
		WestSideEntity entity = manager.find(WestSideEntity.class, id);
		return entity;
	}

	@Override
	public List<WestSideEntity> findByUserName(String userName) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByUserName");
		query.setParameter("userName", userName);
		List<WestSideEntity> entity = query.getResultList();
		return entity;
	}

	@Override
	public List<WestSideEntity> findByAddress(String address) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByAddress");
		query.setParameter("address", address);
		List<WestSideEntity> entity = query.getResultList();
		return entity;
	}

	@Override
	public List<WestSideEntity> findByEmail(String email) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByEmail");
		query.setParameter("email", email);
		List<WestSideEntity> entity = query.getResultList();
		return entity;
	}

	@Override
	public List<WestSideEntity> findByPhoneNo(String phoneNo) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findByPhoneNo");
		query.setParameter("phoneNo", phoneNo);
		List<WestSideEntity> entity = query.getResultList();
		return entity;
	}

	@Override
	public boolean deleteById(int id) {
	EntityManager manager= factory.createEntityManager();
	WestSideEntity entity = manager.find(WestSideEntity.class, id);
	if(entity!=null) {
	manager.getTransaction().begin();
	manager.remove(entity);
	manager.getTransaction().commit();
	manager.close();
	return true;
	}else {
		return false;
		
	}
}

	@Override
	public List<WestSideEntity> deleteByName(String userName) {
    EntityManager manager = factory.createEntityManager();
    Query query = manager.createNamedQuery("findByUserName");
    query.setParameter("userName", userName);
    List<WestSideEntity> entity = query.getResultList();
    
    manager.getTransaction().begin();
    Query  query1 = manager.createNamedQuery("findByUserName");
    query1.setParameter("userName",userName);
    
    for (WestSideEntity westSideEntity : entity) {
		manager.remove(westSideEntity);
	
	}
    
    manager.getTransaction().commit();
    manager.close();       
	return entity;
	}

	@Override
	public boolean onUpdate(WestSideDto dto) {
	System.out.println("update in repo");
    EntityManager manager = factory.createEntityManager();
    WestSideEntity entity = new WestSideEntity();
    BeanUtils.copyProperties(dto, entity);
    EntityTransaction transaction = manager.getTransaction();
    transaction.begin();
    manager.merge(entity);
    transaction.commit();
    manager.close();
		return true;
	}
	
}
