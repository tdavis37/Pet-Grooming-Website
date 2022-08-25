package com.petgrooming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.petgrooming.domain.Pets;
import com.petgrooming.repository.PetRepository;


@Service
public class PetGroomingServices implements IPetGroomingService {
	@Autowired
	private PetRepository repo;
	
	@Override
	public List<Pets> listAll() {
		return repo.findAll();
	}
	
	@Override
	public void save(Pets std) {
			repo.save(std);
	}
	
	@Override
	public Pets get(int id) {
		return repo.findById((long) id).get();
	}
	
	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	public List<Pets> findByTypeBreedAge(String type,String breed,String age) {
		String[] arrAgeStrings = age.split("-");
		if(arrAgeStrings != null && arrAgeStrings.length == 1) {
			arrAgeStrings = new String[]{arrAgeStrings[0],"1000"};
		}
		int ageFrom = Integer.parseInt(arrAgeStrings[0]);
		int ageTo = Integer.parseInt(arrAgeStrings[1]);
		List<Pets> lstRet = repo.findByTypeBreedAge(type, breed, ageFrom, ageTo);
		return lstRet;
	}
}
