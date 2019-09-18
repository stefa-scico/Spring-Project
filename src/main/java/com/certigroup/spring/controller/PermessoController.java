package com.certigroup.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.certigroup.spring.model.Permesso;
import com.certigroup.spring.repository.PermessoRepository;

@Controller
@RequestMapping(value="/api/permessi")
public class PermessoController {
	
	@Autowired
	private PermessoRepository permessoRepo;
	
	public PermessoController() {}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<Permesso> get()
	{
		return permessoRepo.get();
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Permesso get(@PathVariable("id") int id)
	{
		return permessoRepo.get(id);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public boolean create(@RequestBody Permesso perm) {
		return permessoRepo.add(perm);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delete(@PathVariable("id") int id) {
		return permessoRepo.remove(id);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public boolean update(@PathVariable("id") int id, @RequestBody Permesso perm) {
		return permessoRepo.update(id, perm);
	}

}
