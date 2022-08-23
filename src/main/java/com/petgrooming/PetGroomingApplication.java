package com.petgrooming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class PetGroomingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetGroomingApplication.class, args);
	}

}
