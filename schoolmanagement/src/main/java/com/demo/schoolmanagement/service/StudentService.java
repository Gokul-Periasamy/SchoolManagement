package com.demo.schoolmanagement.service;

import org.springframework.stereotype.Service;

import com.demo.schoolmanagement.entity.Student;

@Service
public interface StudentService {
	
	public long saveStudentDetails(Student studentDto);
	
	public Student getStudentByStudentId(long id);
	
	public Boolean deleteStudentById(long id);
	
	public long updateStudentById(long id , Student studentDTO);

}
