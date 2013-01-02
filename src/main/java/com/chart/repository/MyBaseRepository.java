package com.chart.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface MyBaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

	T save(T entity);
	T findOne(ID id);
	boolean exists(ID id);
	Page<T> findAll(Pageable pageable);
}
