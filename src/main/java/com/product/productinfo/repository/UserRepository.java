package com.product.productinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.productinfo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//@Query("select email from user where user.email = 1")
	//public List<User> getuserbyemail(String email);

	User findByEmail(String email); 
}
