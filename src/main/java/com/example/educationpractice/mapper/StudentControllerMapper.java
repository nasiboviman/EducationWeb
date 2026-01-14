package com.example.educationpractice.mapper;

import com.example.educationpractice.controller.dto.StudentRequestDto;
import com.example.educationpractice.controller.dto.StudentResponseDto;
import com.example.educationpractice.service.dto.StudentServiceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentControllerMapper {



//    StudentControllerMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(StudentControllerMapper.class); ); // proyekt isleyirse bunu sil

    StudentResponseDto toResponseDto(StudentServiceDto serviceDto);

    List<StudentResponseDto> toResponseDtoList(List<StudentServiceDto> serviceDto);

    StudentServiceDto toServiceDto(StudentRequestDto requestDto);



}
