package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@CrossOrigin(origins = { "*", "http://localhost:4200", "http://localhost:4200/" })
	public List<Bank> searchBank(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "country", required = false) String country,
			@RequestParam(value = "state", required = false) String state) {
		if (name == null)
			name = "";
		if (country == null)
			country = "";
		if (state == null)
			state = "";
		return repo.getByNameAndCountryAndState("%"+ name + "%","%"+country + "%", "%"+state + "%");

	}

	@RequestMapping(value = "/addBank/")
	@ResponseBody
	@CrossOrigin(origins = { "*", "http://localhost:4200", "http://localhost:4200/" })
	public Bank addBank(@RequestBody Bank newBankFromJsonString) {
		return repo.save((newBankFromJsonString));

	}

	@RequestMapping(value = "/addBanks/", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin(origins = { "*", "http://localhost:4200", "http://localhost:4200/" })
	public List<Bank> addBanks(@RequestBody List<Bank> newBankFromJsonString) {
		return repo.saveAll((newBankFromJsonString));

	}

	@RequestMapping("/getBank/")
	@ResponseBody
	@CrossOrigin(origins = { "*", "http://localhost:4200", "http://localhost:4200/" })
	public List<Bank> getBank(@RequestParam(value = "bic", required = true) String bic) {
		System.out.println("getBank");
		return repo.getByBIC(bic);

	}

	@RequestMapping("/test")
	@ResponseBody
	public String getTest() {
		System.out.println("Test");
		return "Testsssssssssssss";

	}
}
