package com.eidiko.niranjana.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.eidiko.niranjana.entity.StudentsBO;
@Repository
public class StudentsDAOImpl4 implements StudentsDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<StudentsBO> getStudentsDetailsByName(String name) {
		System.out.println("getStudentsDetailsByName method in DAO impl class");
		String retrieveMultipleData = "select sno,sname,saddrs,ssal from Students where sname=?";
		List<StudentsBO> listBO=null;
		BeanPropertyRowMapper<StudentsBO> bprm = null;
		bprm = new BeanPropertyRowMapper<StudentsBO>(StudentsBO.class);
		listBO=jdbcTemplate.query(retrieveMultipleData,  new RowMapperResultSetExtractor<StudentsBO>(bprm),name);
				
		return listBO;
	}
//========================================================================================
	@Override
	public List<StudentsBO> getStudentsDetailsByMultipleName(String name1, String name2, String name3) {
		System.out.println("getStudentsDetailsByMultipleName method in DAO impl class");
		String retrieveMultipleData = "select sno,sname,saddrs,ssal from Students where sname IN(?,?,?)";
		List<StudentsBO> listBO=null;
		BeanPropertyRowMapper<StudentsBO> bprm = null;
		bprm = new BeanPropertyRowMapper<StudentsBO>(StudentsBO.class);
		listBO=jdbcTemplate.query(retrieveMultipleData,  new RowMapperResultSetExtractor<StudentsBO>(bprm),name1,name2,name3);
				
		return listBO;
	}
}
