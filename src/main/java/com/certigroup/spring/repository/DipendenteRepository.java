package com.certigroup.spring.repository;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.certigroup.spring.model.Dipendente;

public class DipendenteRepository implements Repository<Dipendente> {
	int lastId;
	Map<Integer, Dipendente> dipData = new HashMap<Integer, Dipendente>();
	
	public DipendenteRepository() {
		GregorianCalendar cal = new GregorianCalendar(-1991, 1, 17);
		dipData.put(1, new Dipendente(1, "michele", "porro", cal.getTime()));
		cal = new GregorianCalendar(1995, 12, 22);
		dipData.put(2, new Dipendente(2, "stefano", "scicu", cal.getTime()));
		cal = new GregorianCalendar(1994, 3, 23);
		dipData.put(3, new Dipendente(3, "simone", "stu", cal.getTime()));
		lastId=3;
	}

	@Override
	public List<Dipendente> get() {
		ArrayList<Dipendente> dipendenti = new ArrayList<Dipendente>();
		for(Integer key : dipData.keySet()) {
			dipendenti.add(dipData.get(key));
		}
		return dipendenti;
	}

	@Override
	public Dipendente get(int id) {
		
		try {
			return dipData.get(id);
		}catch(Exception ex) {
			return null;
		}
		
		
	}

	@Override
	public boolean add(Dipendente el) {
		try {
			lastId++;
			el.setId(lastId);
			dipData.put(lastId, el);
			return true;
		}		
		catch(Exception ex){
			return false;
		}
	}

	@Override
	public boolean update(int id, Dipendente el) {
		try {
			dipData.replace(id, el);
			return true;
		}
		catch(Exception ex){
			return false;
		}		
	}

	@Override
	public boolean remove(int id) {
		try {
			dipData.remove(id);
			return true;
		}
		catch(Exception ex){
			return false;
		}	
	}

}
