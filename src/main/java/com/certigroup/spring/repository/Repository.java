package com.certigroup.spring.repository;

import java.util.List;

public interface Repository<T> {
	public List<T> get();
	
	public T get(int id);
	
	public boolean add(T el);
	
	public boolean update(int id, T el);
	
	public boolean remove(int id);
}
