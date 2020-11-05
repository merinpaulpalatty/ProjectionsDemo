package com.ust.projections.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.ust.projections.VO.PersonVO;
import com.ust.projections.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	
	Person toEntity(PersonVO personVO);
	
	PersonVO toPersonVO(Person person);
	
	List<PersonVO> toPersonVOList(List<Person> people);
	

}
