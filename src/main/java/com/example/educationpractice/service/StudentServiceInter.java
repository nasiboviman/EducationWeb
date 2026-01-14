package com.example.educationpractice.service;

import com.example.educationpractice.service.dto.StudentServiceDto;

import java.math.BigDecimal;
import java.util.List;

public interface StudentServiceInter {


    public List<StudentServiceDto> getStudents(String name,
                                               String surname,
                                               Integer age,
                                               BigDecimal scholarship,
                                               Integer universityId) ;

    public void deleteById(Integer id) ;
    public StudentServiceDto create(StudentServiceDto studentServiceDto);
    public StudentServiceDto getStudentById(Integer id);


}
