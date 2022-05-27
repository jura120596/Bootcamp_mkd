package com.samsung.service;

import java.util.List;

public interface BaseService<T> {
	List<T> getAll();
	T getById(long id);
	void deleteById(long id);
	void save(T entity);
}
