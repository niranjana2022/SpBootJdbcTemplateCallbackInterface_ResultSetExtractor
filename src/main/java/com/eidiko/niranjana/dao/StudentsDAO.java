package com.eidiko.niranjana.dao;


import java.util.List;


import com.eidiko.niranjana.entity.StudentsBO;

public interface StudentsDAO {
	
	
	public List<StudentsBO> getStudentsDetailsByName(String name); //Using query method:- ResultSetExtractor(I) extractData method
	
	public List<StudentsBO> getStudentsDetailsByMultipleName(String name1, String name2, String name3);
}
