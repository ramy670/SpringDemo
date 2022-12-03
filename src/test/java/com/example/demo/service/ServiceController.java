package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.BankRepo;
import com.example.demo.model.Bank;

@Controller
public class ServiceController {

	@Autowired
	private BankRepo repo;
	
	@RequestMapping("/searchBank/")
	@ResponseBody
	public List<Bank> searchBank(
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="country", required=false) String country,
			@RequestParam(value="state", required=false) String state) {
		System.out.println("searchBank");
		return repo.getByNameAndCountryAndState( name,country,state);
		
	}

	@RequestMapping(value="/addBank/", method = RequestMethod.POST)
	@ResponseBody
	public Bank addBank(@RequestBody Bank newBankFromJsonString) {
		System.out.println("addBank");
		
		return repo.save((newBankFromJsonString));
		
	}

	@RequestMapping("/getBank/")
	@ResponseBody
	public List<Bank> getBank(@RequestParam(value="bic", required=true) String bic) {
		System.out.println("getBank");

		return repo.getByBIC(bic);
		
	}

	@RequestMapping("/test/")
	@ResponseBody
	public String getBank() {
		System.out.println("Test");
		return "Test";
		
	}
}
