package com.example.educationpractice.mapper;

import com.example.educationpractice.controller.dto.StudentRequestDto;
import com.example.educationpractice.controller.dto.StudentResponseDto;
import com.example.educationpractice.controller.dto.TeacherRequestDto;
import com.example.educationpractice.controller.dto.TeacherResponseDto;
import com.example.educationpractice.service.dto.StudentServiceDto;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherControllerMapper {

    TeacherResponseDto toResponseDto(TeacherServiceDto serviceDto);

    List<TeacherResponseDto> toResponseDtoList(List<TeacherServiceDto> serviceDto);

    TeacherServiceDto toServiceDto(TeacherRequestDto requestDto);

}
