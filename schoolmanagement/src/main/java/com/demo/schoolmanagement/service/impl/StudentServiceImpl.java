package com.demo.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.schoolmanagement.entity.Student;
import com.demo.schoolmanagement.repository.StudentRepository;
import com.demo.schoolmanagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	 StudentRepository studentRepository;

	@Override
	public long saveStudentDetails(Student studentDto) {
		
		long id = 0 ;
		try {
			id = studentRepository.saveAndFlush(studentDto).getId();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public Student getStudentByStudentId(long id) {
	
		return studentRepository.getOne(id);
	}

	@Override
	public Boolean deleteStudentById(long id) {
		
		boolean status = true;
		
		try{
			studentRepository.deleteById(id);
			
		}catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		
		return status;
	}
	
	

}
