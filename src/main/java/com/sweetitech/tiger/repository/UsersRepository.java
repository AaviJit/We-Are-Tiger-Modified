package com.sweetitech.tiger.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sweetitech.tiger.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findById(long id);
	User findByPhoneNumber(String phoneNumber);
	User findByFirstName(String firstName);
	
	Page<User> findAllUserByRoles_Name(String name, Pageable pageable);
}
