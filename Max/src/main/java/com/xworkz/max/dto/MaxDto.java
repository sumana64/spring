package com.xworkz.max.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaxDto {
	 
	private int id;
	
	@Size(min = 3,max =30,message="check the length size with min=2 nd max=30")
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	@Email
	private String email;
	@Positive
	private long phoneNo;
	@Size(min = 3,max =30,message="check the length size with min=2 nd max=30")
	@NotNull
	@NotBlank
	private String address;

}
