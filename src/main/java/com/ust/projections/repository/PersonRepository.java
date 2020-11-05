package com.ust.projections.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.projections.entity.Person;
import com.ust.projections.projectionsInterface.PersonInterface;

public interface PersonRepository  extends JpaRepository<Person, java.lang.Long>{

	List<PersonInterface> findByCity(String city);
	
	<T> List<T> findByGender(String gender,Class<T> type);	

}
