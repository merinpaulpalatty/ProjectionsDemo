package com.ust.projections.service;

import java.util.List;

import com.ust.projections.VO.PersonVO;
import com.ust.projections.projectionsInterface.PersonInterface;


public interface PersonService {

	boolean savePerson(PersonVO personVO);

	List<PersonVO> getAllPeople();
	
	PersonVO getPersonById(long id);
	
	List<PersonInterface> getGenderAndAge(String city);

	List<PersonVO> getAllNames(String gender);
	
	List<PersonInterface> getAllNamesUsingInterface(String gender);

}
