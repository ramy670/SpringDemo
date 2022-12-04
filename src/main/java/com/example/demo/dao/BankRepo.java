package com.example.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer> {
	public List<Bank> getByNameAndCountryAndState(String name,String country,String state);	
	public List<Bank> getByBIC(String BIC);	
	
}




