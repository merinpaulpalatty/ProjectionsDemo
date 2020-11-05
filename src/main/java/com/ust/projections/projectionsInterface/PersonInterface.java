package com.ust.projections.projectionsInterface;

import org.springframework.beans.factory.annotation.Value;

public interface PersonInterface {
	
	String getGender();
	String getName();
	int getAge();
	
	@Value("#{target.name +'paul'}")
	String getEntho();
	
	default String getFullName() {
	    return getName().concat(" Paul");
	  }
	
	
	AddressSummary getAddress();
	
	interface AddressSummary {	
		String getHouseName();
	}
	

}
