/**
 * 
 */
package com.petgrooming.repository;

import static org.assertj.core.api.Assertions.assertThat;


import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.petgrooming.domain.Pets;

@DataJpaTest
@AutoConfigureTestDatabase

/**
 * @author Tealen Davis
 *
 */
class PetRepositoryTest {
	@Autowired
	private PetRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	@Test
	void test() {
		Pets pets = new Pets();
		pets.setPettype("Cat");
		pets.setBreed("Domestic - ShortHaired");
		pets.setAge("2 months - 5 months");
		
		Pets savedPets = repo.save(pets);
		Pets existPets = entityManager.find(Pets.class, savedPets .getId());
		assertThat(existPets.getPettype()).isEqualTo(pets.getPettype());
	}

}
