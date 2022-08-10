package com.ojas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	private int id;
	private String name;

	private String username;
	private String email;
	private String phone;
	private String password;
	private String cpassword;
	private String gender;
}
