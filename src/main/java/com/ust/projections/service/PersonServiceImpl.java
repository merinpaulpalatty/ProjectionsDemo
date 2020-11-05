package com.ust.projections.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.projections.VO.PersonVO;
import com.ust.projections.entity.Person;
import com.ust.projections.mapper.PersonMapper;
import com.ust.projections.projectionsInterface.PersonInterface;
import com.ust.projections.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repo;
	@Autowired
	private PersonMapper mapper;

	@Override
	public boolean savePerson(PersonVO personVO) {
		repo.save(mapper.toEntity(personVO));
		return true;
	}

	@Override
	public List<PersonVO> getAllPeople() {
		return mapper.toPersonVOList(repo.findAll());
	}

	@Override
	public PersonVO getPersonById(long id) {
		return mapper.toPersonVO(repo.findById(id).get());
	}

	@Override
	public List<PersonInterface> getGenderAndAge(String city) {
		return repo.findByCity(city);
	}

	@Override
	public List<PersonVO> getAllNames(String gender) {
		return mapper.toPersonVOList(repo.findByGender(gender, Person.class));
	}

	@Override
	public List<PersonInterface> getAllNamesUsingInterface(String gender) {
		return repo.findByGender(gender, PersonInterface.class);
	}

}
