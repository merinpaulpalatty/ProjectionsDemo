package com.ust.projections.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ust.projections.VO.PersonVO;
import com.ust.projections.entity.Person;
import com.ust.projections.mapper.PersonMapper;
import com.ust.projections.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {
	
	@Autowired
	private PersonService service;
	@Autowired
	private PersonMapper mapper;
	@MockBean
	private PersonRepository repo;

	private PersonVO vo;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		vo = new PersonVO();	
		vo.setId(10);
		vo.setName("dhoni");
		vo.setAge(30);
		vo.setGender("male");
		vo.setCity("ranchi");
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSavePersonSuccess() {
		Person person = mapper.toEntity(vo);
		when(repo.save(person)).thenReturn(person);
		boolean status = service.savePerson(vo);
		assertEquals(true, status);
		//verify(repo , times(1)).save(person);
	}
	
	
}
