package com.eidiko.niranjana.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.dao.StudentsDAO;
import com.eidiko.niranjana.dto.StudentsDTO;
import com.eidiko.niranjana.entity.StudentsBO;
@Service
public class StudentsServiceImpl implements StudentsService{

	@Autowired
	private StudentsDAO stdDao;


	@Override
	public List<StudentsDTO> fetchStudentsDetailsByName(String name) {
		
		List<StudentsBO> listBO = null;
		List<StudentsDTO> listDTO=new ArrayList();
		System.out.println("fetchStudentsDetailsByName method in service impl class");
		
		listBO = stdDao.getStudentsDetailsByName(name);
		System.out.println("listBO in service Impl class is : "+listBO);
		listBO.forEach(bo->{
			StudentsDTO dto=new StudentsDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
						});
	return listDTO;
	}

	@Override
	public List<StudentsDTO> fetchStudentsDetailsByMultipleName(String name1, String name2, String name3) {
		System.out.println("fetchStudentsDetailsByName method of StudentsServiceImpl class");
		List<StudentsBO> listBO = null;
		List<StudentsDTO> listDTO=new ArrayList();
		
		listBO = stdDao.getStudentsDetailsByMultipleName(name1, name2, name3);
		System.out.println("listBO in service Impl class is : "+listBO);
		listBO.forEach(bo->{
			StudentsDTO dto=new StudentsDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
						});
	return listDTO;
	
	}

}
