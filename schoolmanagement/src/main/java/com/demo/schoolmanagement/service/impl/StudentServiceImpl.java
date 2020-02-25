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

	@Override
	public long updateStudentById(long id , Student studentDTO) {
		
		try {
			 Student student = studentRepository.getOne(id);
			 if(studentDTO.getDob() != null) {
				 student.setDob(studentDTO.getDob());	 
			 }
			 if(studentDTO.getFirstName() != null) {
				 student.setFirstName(studentDTO.getFirstName());
			 }
			 if(studentDTO.getLastName() != null) {
				 student.setLastName(studentDTO.getLastName());
			 }
			 if(studentDTO.getFatherName() != null) {
				 student.setFatherName(studentDTO.getFatherName()); 
			 }
			 if(studentDTO.getMotherName() != null) {
				 student.setMotherName(studentDTO.getMotherName());
			 }
			 if(studentDTO.getEmail() != null) {
				 student.setEmail(studentDTO.getEmail());
			 }
			 studentRepository.save(student);
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		return id;
	}
	
	

}
