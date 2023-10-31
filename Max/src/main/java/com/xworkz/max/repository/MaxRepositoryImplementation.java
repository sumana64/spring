package com.xworkz.max.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.entity.MaxEntity;
import com.xworkz.max.dto.MaxDto;

@Repository
public class MaxRepositoryImplementation implements MaxRepository {
	
	@Autowired
	EntityManagerFactory factory;
	
   public MaxRepositoryImplementation() {
		System.out.println("MaxRepositoryImplementation is created");
	}

	@Override
	public boolean onSave(MaxDto dto) {
		System.out.println("this is save method in repository");
		MaxEntity entity = new MaxEntity();
		BeanUtils.copyProperties(dto, entity);
		EntityManager manager =factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public List<MaxEntity> findAll() {
		System.out.println("this read method in repository");
		EntityManager manager = factory.createEntityManager();
		Query query  = manager.createNamedQuery("findAll");
		List<MaxEntity> list=query.getResultList();
		for (MaxEntity maxEntity : list) {
			System.out.println("entity list " + maxEntity);
		}
		System.out.println("list" + list);
		return list;
	}

	@Override
	public MaxEntity findById(int id) {
		System.out.println("findBy in repository");
		EntityManager manager = factory.createEntityManager();
		MaxEntity entity = manager.find(MaxEntity.class, id);
		System.out.println(entity);
		return entity;
	}

	@Override
	public List<MaxEntity> findByEmail(String email) {
		System.out.println("findByemail in repository");
		EntityManager manager = factory.createEntityManager();
	    Query query = manager.createNamedQuery("findByEmail");
	    query.setParameter("email", email);
	    List<MaxEntity> entity=query.getResultList();
		return entity;
	}

	@Override
	public boolean deleteById(int id) {
		System.out.println("delete by id in repository");
		EntityManager manager = factory.createEntityManager();
	    MaxEntity entity = manager.find(MaxEntity.class, id);
	    EntityTransaction transaction = manager.getTransaction();
	    transaction.begin();
	    manager.remove(entity);
	    transaction.commit();
	    manager.close();
		return true;
	}

	@Override
	public boolean onUpdate(MaxDto dto) {
		System.out.println("updateid in repo");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		MaxEntity entity = new MaxEntity();
		BeanUtils.copyProperties(dto, entity);
	    transaction.begin();
	    manager.merge(entity);
	    transaction.commit();
	    manager.close();
		return true;
	}

}
