package com.example.demo.dao;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.demo.model.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer>,QueryByExampleExecutor<Bank> {
	@Query(value="SELECT b FROM Bank b WHERE  b.name LIKE :name  and  b.country LIKE :country  and b.state LIKE :state ")
	public List<Bank> getByNameAndCountryAndState(@Param("name")String name,@Param("country")String country,@Param("state")String state);	
	
	public List<Bank> getByBIC(String BIC);	
	
}




