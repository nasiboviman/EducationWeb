package com.example.educationpractice.controller.dto;

import com.example.educationpractice.service.dto.UniversityServiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;
    private UniversityServiceDto university;


    public StudentResponseDto(Integer id) {
        this.id = id;
    }
}
