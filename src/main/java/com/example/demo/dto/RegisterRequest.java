package com.example.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter

public class RegisterRequest {
	
private long id;

	
	private String userName;

	private String emailid;

	
	private String password;


	private Date dob;


	private String gender;

	private String address;

	
	private String contactno;

	
	private String accountno;

	private String branchname;

	private String depoamount;

}
