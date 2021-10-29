package com.example.customerLogin;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DataRepo extends CrudRepository<User, Integer> {

	@Query("select u from User u")
	public List<User> findAll();
	
	@Query("select u from User u where u.name=:n")
	public List<User> findByNa(@Param(value = "n") String name);
}
