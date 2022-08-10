package com.ojas.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="userregister", uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;
	private String name;

	private String username;
	private String email;
	private String phone;
	private String password;
	private String cpassword;
    private String gender;
   // private String verificationCode;
    
//	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	@JoinTable(
//			name="user_roles",
//			joinColumns=@JoinColumn(name="user_id",referencedColumnName="id"),
//			inverseJoinColumns=@JoinColumn(
//					name="role_id",referencedColumnName="id")
//			)
//	
//	private Collection<Role> roles;

}
