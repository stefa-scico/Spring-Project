package com.certigroup.spring.repository;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.certigroup.spring.model.Dipendente;
import com.certigroup.spring.model.Permesso;

public class PermessoRepository implements Repository<Permesso> {

	int lastId;
	
	DipendenteRepository dipendenteRepo;
	
	Map<Integer, Permesso> permData = new HashMap<Integer, Permesso>();
	
	public PermessoRepository(DipendenteRepository dipendenteRepo) {
		this.dipendenteRepo=dipendenteRepo;
		
		Dipendente dip1 = dipendenteRepo.get(1);
		Dipendente dip2 = dipendenteRepo.get(2);
		Dipendente dip3 = dipendenteRepo.get(3);
		
		GregorianCalendar cal = new GregorianCalendar(-1991, 1, 17);
		permData.put(1, new Permesso(1,3,cal.getTime(),dip1));
		cal = new GregorianCalendar(1995, 12, 22);
		permData.put(2, new Permesso(2, 4,cal.getTime(),dip2));
		cal = new GregorianCalendar(1994, 3, 23);
		permData.put(3, new Permesso(3,5,cal.getTime(),dip3));
		lastId=3;
	}
	@Override
	public List<Permesso> get() {
		ArrayList<Permesso> permessi = new ArrayList<Permesso>();
		for(Integer key : permData.keySet()) {
			permessi.add(permData.get(key));
		}
		return permessi;
	}

	@Override
	public Permesso get(int id) {
		try {
			return permData.get(id);
		}catch(Exception ex) {
			return null;
		}
		
	}

	@Override
	public boolean add(Permesso el) {
		try {
			lastId++;
			el.setId(lastId);
			permData.put(lastId, el);
			return true;
		}		
		catch(Exception ex){
			return false;
		}
	}

	@Override
	public boolean update(int id, Permesso el) {
		try {
			permData.replace(id, el);
			return true;
		}
		catch(Exception ex){
			return false;
		}	
	}

	@Override
	public boolean remove(int id) {
		try {
			permData.remove(id);
			return true;
		}
		catch(Exception ex){
			return false;
		}	
	}

}
