package com.petgrooming;

public interface IAppService {
	Customer authenticate(String username,String password);
	Customer register(Customer customer);
}
