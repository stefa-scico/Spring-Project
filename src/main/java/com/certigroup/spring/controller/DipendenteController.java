package com.certigroup.spring.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.certigroup.spring.model.Dipendente;
import com.certigroup.spring.repository.DipendenteRepository;

@Controller
@RequestMapping("/api/dipendente")
public class DipendenteController {
	
	private DipendenteRepository dipendenteRepo;
	
	@Autowired
	public DipendenteController(DipendenteRepository dipendenteRepo) {
		this.dipendenteRepo = dipendenteRepo;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Dipendente> get()
	{
		return dipendenteRepo.get();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Dipendente get(@PathVariable("id") int id)
	{
		return dipendenteRepo.get(id);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public boolean create(@RequestBody Dipendente deep) {
		return dipendenteRepo.add(deep);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delete(@PathVariable("id") int id) {
		return dipendenteRepo.remove(id);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public boolean update(@PathVariable("id") int id, @RequestBody Dipendente deep) {
		return dipendenteRepo.update(id, deep);
	}
}
