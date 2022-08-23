package com.petgrooming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)


public class CustomerRepositoryTests {
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("runningupthathill@gmail.com");
		customer.setPassword("prettykitty2022");
		customer.setFirstName("Max");
		customer.setLastName("Mayfield");
		
		Customer savedCustomer = repo.save(customer);
		Customer existCustomer = entityManager.find(Customer.class, savedCustomer .getId());
		assertThat(existCustomer.getEmail()).isEqualTo(customer.getEmail());
		
	}

}
