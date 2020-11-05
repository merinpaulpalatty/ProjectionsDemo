package com.ust.projections.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.projections.VO.PersonVO;
import com.ust.projections.projectionsInterface.PersonInterface;
import com.ust.projections.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping
	public ResponseEntity<?> savePerson(@RequestBody PersonVO personVO) {
		if (personService.savePerson(personVO))
			return new ResponseEntity<>("saved", HttpStatus.CREATED);
		return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping
	public ResponseEntity<?> getAllPeople() {
		List<PersonVO> vos = personService.getAllPeople();
		return new ResponseEntity<>(vos, HttpStatus.OK);
	}

	@GetMapping("/getPerson/{id}")
	public ResponseEntity<?> getPerson(@PathVariable long id) {
		PersonVO vo = personService.getPersonById(id);
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}

	@GetMapping("/getGenderAndAge/{city}")
	public ResponseEntity<?> getGenderAndAge(@PathVariable String city) {
		List<PersonInterface> vos = personService.getGenderAndAge(city);
		return new ResponseEntity<>(vos, HttpStatus.OK);
	}

	@GetMapping("/getAllNames/{gender}")
	public ResponseEntity<?> getAllNames(@PathVariable String gender) {
		// List<PersonVO> vos= personService.getAllNames(gender);
		List<PersonInterface> vos = personService.getAllNamesUsingInterface(gender);
		return new ResponseEntity<>(vos, HttpStatus.OK);
	}

}
