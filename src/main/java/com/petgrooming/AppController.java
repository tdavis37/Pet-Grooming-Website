package com.petgrooming;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Controller
@RequestMapping("/app")
public class AppController {
	@Autowired
	private IAppService appService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<Customer> authenticate(@RequestBody Map<String,String> mapData) {
		return ResponseEntity.ok(appService.authenticate(mapData.get("username"), mapData.get("password")));
	}
	
	@PostMapping("/register")
	public ResponseEntity<Customer> register(@RequestBody Customer customer) throws Exception {
		try {
			Customer cust = appService.register(customer);
			return ResponseEntity.ok(cust);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
}
