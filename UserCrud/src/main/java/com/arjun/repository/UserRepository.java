package com.arjun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arjun.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

//	@Query("from User where username=?1 and password=?2")
//	public User findByUsernamePassword(String username,String password);
	
	@Query("from User where username=?1 and password=?2")
	User loginuser(String username,String password);
	
	
}
