package com.petgrooming.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pets {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String pettype;
    private String breed;
    private String age;
    private int fee;
	public Pets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pets(Long id, String pettype, String breed, String age, int fee) {
		super();
		this.id = id;
		this.pettype = pettype;
		this.breed = breed;
		this.age = age;
		this.fee = fee;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPettype() {
		return pettype;
	}
	public void setPettype(String pettype) {
		this.pettype = pettype;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
    
    
    
}
