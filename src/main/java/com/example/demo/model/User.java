package com.example.demo.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@Entity 
@Table(name = "user")
public class User {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "userName")
private String userName;

@Column(name = "email_id")
private String emailid;

@Column(name = "password")
private String password;

@Column(name = "dob")
private Date dob;

@Column(name = "gender")
private String gender;

@Column(name = "address")
private String address;

@Column(name = "contact_no")
private String contactno;

@Column(name = "account_no")
private String accountno;

@Column(name = "branch_name")
private String branchname;

@Column(name = "depo_amount")
private String depoamount;



}