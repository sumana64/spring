package com.xworkz.westSide.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WestSideDto {
	
	  private int id;
	  @Size(min = 3,max =15,message="check the userName size min = 3 max = 30")
	  @NotBlank
	  @NotNull
	  private String userName;
	  @NotBlank
	  @NotNull
	  @Email
	  private String email;
	  @Positive
	  private long phoneNo;
	  @Size(min = 3,max =15,message="check the address size min = 3 max = 30")
	  @NotBlank
	  @NotNull                    //pattern - gender ,is married, password
	  private String address;
	  @NotBlank
	  @NotNull
	  private String passWord;
	  @Size(min = 3,max =15,message="check the userName size min = 3 max = 30")
	  @NotBlank
	  @NotNull
	  private String gender;
	  @Size(min = 3,max =15,message="check the userName size min = 3 max = 30")
	  @NotBlank
	  @NotNull
	  private String shoppingFor;
	

}
