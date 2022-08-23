package com.petgrooming.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.petgrooming.domain.Pets;

public interface PetRepository extends JpaRepository<Pets, Long>{
	@Query(value="Select * from petgrooming.pets\r\n"
			+ "where pettype = :type and breed = :breed\r\n"
			+ "and age >= :ageFrom and age <= :ageTo",nativeQuery=true)
	public List<Pets> findByTypeBreedAge(@Param("type") String type,@Param("breed") String breed,@Param("ageFrom") int ageFrom,@Param("ageTo")int ageTo);
}
