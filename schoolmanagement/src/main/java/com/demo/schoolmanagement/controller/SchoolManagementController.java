package com.demo.schoolmanagement.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.schoolmanagement.dto.RestResponse;
import com.demo.schoolmanagement.entity.Student;
import com.demo.schoolmanagement.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping(value = "/studentManagement")
public class SchoolManagementController {

	private static final Logger logger = LoggerFactory.getLogger(SchoolManagementController.class);

	@Autowired
	 StudentService studentService;

	@RequestMapping(value = "/insertStudent", method = RequestMethod.POST , consumes= {"application/json"} ,produces= {"application/json"} )
	public ResponseEntity<RestResponse> insertStudent(@Valid @RequestBody Student studentDTO) {

		logger.info("Save Request: {}", studentDTO);

		Long studentId = null;
		RestResponse resposne = new RestResponse();

		try {

			studentId = studentService.saveStudentDetails(studentDTO);
			logger.info("Last Generated Id: {} ", studentId);
			resposne.setMessage("Success");
			resposne.setData("id", studentId);
		} catch (Exception e) {
			resposne.setMessage("Save Failed");
			resposne.setData("id", studentId);
			return new ResponseEntity<>(resposne, HttpStatus.EXPECTATION_FAILED);
		}

		return new ResponseEntity<>(resposne, HttpStatus.ACCEPTED);

	}
	
	
	@RequestMapping(value = "/getStudentbyId/{id}")
	public ResponseEntity<RestResponse> getStudentDetails(@PathVariable Long id) {

		RestResponse resposne = new RestResponse();
		Student student = null;
		
	
		if(id != null ) {	
			 student = studentService.getStudentByStudentId(id);
			
		}else {
			resposne.setMessage("Failure");
			return new ResponseEntity<>(resposne, HttpStatus.BAD_REQUEST);
		}
		
		if(student != null) {
			resposne.setMessage("Success");
			resposne.setData("student",student);
		}else {
			resposne.setMessage("No Details found");
			
		}
		return new ResponseEntity<>(resposne, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/deleteStudentbyId/{id}")
	public ResponseEntity<RestResponse> deleteStudent(@PathVariable Long id) {
		
		logger.info("Delete Id: {}", id);
		
		RestResponse resposne = new RestResponse();
		boolean status ;
		if(id != null ) {	
			status =   studentService.deleteStudentById(id);
		}else {
			resposne.setMessage("Failure");
			return new ResponseEntity<>(resposne, HttpStatus.BAD_REQUEST);
		}
		
		if(status) {
			resposne.setMessage("Deleted Successfully");
		}else {
			resposne.setMessage("Failed");
		}
		return new ResponseEntity<>(resposne, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/deleteStudentbyId/{id}")
	public ResponseEntity<RestResponse> updateStudent(@Valid @RequestBody Student studentDTO , @PathVariable Long id) {
		
		RestResponse resposne = new RestResponse();
		
		if(id != null ) {	
			   studentService.updateStudentById(id, studentDTO);
		}else {
			resposne.setMessage("Failure");
			return new ResponseEntity<>(resposne, HttpStatus.BAD_REQUEST);
		}
		
		
			resposne.setMessage("Updated Successfully");
		
		return new ResponseEntity<>(resposne, HttpStatus.OK);		
	}

}
