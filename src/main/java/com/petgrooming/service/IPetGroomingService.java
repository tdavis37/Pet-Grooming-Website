package com.petgrooming.service;

import java.util.List;

import com.petgrooming.domain.Pets;

public interface IPetGroomingService {
	List<Pets> listAll();
	void save(Pets std);
	 Pets get(int id);
	 void delete(long id);
	 List<Pets> findByTypeBreedAge(String type,String breed,String ageFrom);
}
