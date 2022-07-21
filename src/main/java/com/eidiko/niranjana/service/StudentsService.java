package com.eidiko.niranjana.service;


import java.util.List;

import com.eidiko.niranjana.dto.StudentsDTO;

public interface StudentsService {
	
	
	public List<StudentsDTO> fetchStudentsDetailsByName(String name);
	
	public List<StudentsDTO> fetchStudentsDetailsByMultipleName(String name1,String name2, String name3);
	
	

}
