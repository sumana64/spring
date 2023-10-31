package com.xworkz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="westside_table")
@NamedQuery(name = "findAll", query = "select en from WestSideEntity en")
@NamedQuery(name = "findByUserName", query = "select en from WestSideEntity en where en.userName=:userName")
@NamedQuery(name = "findByAddress", query = "select en from WestSideEntity en where en.address=:address")
@NamedQuery(name = "findByEmail", query = "select en from WestSideEntity en where en.email=:email")
@NamedQuery(name = "findByPhoneNo",query = "select en from WestSideEntity en where en.phoneNo=:phoneNo")
@NamedQuery(name = "deleteByUserName", query = "delete from WestSideEntity where userName=:userName")
@NamedQuery(name = "updateByEmail", query="update en WestSideEntity en set en.email=:email")
public class WestSideEntity {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;
		 
	  private String userName;
	  
	  private String email;
	  
	  private long phoneNo;
	  
	  private String address;
	  
	  private String passWord;
	  
	  private String gender;
	  
	  private String shoppingFor;

}
