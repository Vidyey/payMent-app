package com.EazyPay.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.EazyPay.demo.entity.User_Details;

public interface UserDetailRepositoty extends JpaRepository<User_Details, Integer> {
	 
	@Query( value="select * from User_Details where Mobile_Number = ?1", nativeQuery = true)
	User_Details findByMobileNumber(long MobileNumber);

}
