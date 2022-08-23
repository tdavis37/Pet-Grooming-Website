package com.petgrooming;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.petgrooming.domain.Pets;
import com.petgrooming.repository.PetRepository;
import com.petgrooming.service.PetGroomingServices;

@Controller
public class PetGroomingController {
	@Autowired
	private PetRepository petRepository;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/CatGrooming")
	public String CatGrooming() {
		return "CatGrooming";
	}
	
	@RequestMapping("/DogGrooming")
	public String services2() {
		return "DogGrooming";
	}
	@RequestMapping("/servicesDC")
	public String servicesDC() {
		return "servicesDC";
	}
	@RequestMapping("/gallery")
	public String gallery() {
		return "gallery";
	}
	
	@RequestMapping("/l0gin")
	public String l0gin() {
		return "l0gin";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	
	
	@RequestMapping("/registerproduct")
	public String registerproduct(Model model, @RequestParam String petType, @RequestParam String breed, @RequestParam String age) {
		Pets pets = new Pets();
		pets.setPettype(petType);
		pets.setBreed(breed);
		pets.setAge(age);
		pets.setFee(0);
		petRepository.save(pets);
		List<Pets> petList = petRepository.findAll();
		model.addAttribute("petList", petList);
		return "registerproduct";
	}
	
	@RequestMapping("/new")
	  public String add(Model model) {
        model.addAttribute("pets", new Pets());
        return "new";
    }

	
}
