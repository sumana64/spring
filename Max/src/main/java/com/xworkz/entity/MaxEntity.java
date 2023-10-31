package com.xworkz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="max_table")
@NamedQuery(name = "findAll",query = "select en from MaxEntity en")
@NamedQuery(name = "findById", query = "select en from MaxEntity en where en.id =:id")
@NamedQuery(name = "findByEmail", query = "select en from MaxEntity en where en.email=:email")
public class MaxEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String name;
	
	private String email;
	
	private long phoneNo;
	
	private String address;
	
}
