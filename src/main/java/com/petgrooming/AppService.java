package com.petgrooming;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService implements IAppService {
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Customer authenticate(String username,String password) {
		List<Customer> lstCustomer = customerRepo.findByEmail(username);
		if(lstCustomer != null && lstCustomer.size() > 0) {
			for(Customer customer : lstCustomer) {
				if(password.equals(customer.getPassword())) {
					return customer;
				}
			}
		}
		return null;
	}
	
	@Override
	public Customer register(Customer customer) {
		if(customer != null) {
			return customerRepo.save(customer);
		}
		return null;
	}
}
