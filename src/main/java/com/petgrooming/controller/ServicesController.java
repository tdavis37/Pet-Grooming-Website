package com.petgrooming.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petgrooming.Customer;
import com.petgrooming.domain.Pets;
import com.petgrooming.service.IPetGroomingService;

@Controller
public class ServicesController {
	@Autowired
    private IPetGroomingService service;
 
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Pets> listpet = service.listAll();
        model.addAttribute("listpet", listpet);
        System.out.print("Get / ");
        return "index";
    }
 
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savepet(@ModelAttribute("pet") Pets std) {
        service.save(std);
        return "redirect:/";
    }
 
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPetPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Pets std = service.get(id);
        mav.addObject("pet", std);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
    
    @PostMapping("/findByTypeBreedAge")
	public ResponseEntity<List<Pets>> findByTypeBreedAge(@RequestBody Map<String,String> mapData) {
		return ResponseEntity.ok(service.findByTypeBreedAge(mapData.get("type"), mapData.get("breed"), mapData.get("age")));
	}
}
