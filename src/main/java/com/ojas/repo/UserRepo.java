package com.ojas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ojas.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	//@Query("UPDATE userregister u SET u.enabled =true WHERE u.id=?1")
	public User findByUsernameAndPassword(String username, String password);
	
	//@Modifying
//	public void enable(Integer id);
//	
//	@Query("SELECT u FROM userregister u WHERE u.verificationCode=?1")
//	public User findByVerificationCode(String code);



	

	
}
