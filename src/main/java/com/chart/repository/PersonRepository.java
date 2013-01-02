package com.chart.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.chart.domain.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, String> {
	
}
