package com.eidiko.niranjana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.dto.StudentsDTO;
import com.eidiko.niranjana.service.StudentsService;

@RestController
public class StudentsController {
	@Autowired
	private StudentsService stdService; 

	
	
	
	@GetMapping("/fetchStudentsDetailsByName")
	public List<StudentsDTO> fetchStudentsDetailsByStdsName(@RequestParam(value="name") String name) {
		System.out.println("fetchStudentsDetailsByStdsName method in controller class");
		return stdService.fetchStudentsDetailsByName(name);
	}
	
	@GetMapping("/getStudentsDetailsByMultipleName")
	public List<StudentsDTO> retrieveStudentsDetails(@RequestParam(name="name1") String name1,@RequestParam(name="name2") String name2,@RequestParam(name="name3") String name3){
		System.out.println("retrieveStudentsDetails method of Controller class");
		return stdService.fetchStudentsDetailsByMultipleName(name1,name2,name3);
	}
}
