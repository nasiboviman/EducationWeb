package com.example.educationpractice.mapper;


import com.example.educationpractice.controller.dto.UniversityRequestDto;
import com.example.educationpractice.controller.dto.UniversityResponseDto;
import com.example.educationpractice.service.dto.UniversityServiceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UniversityControllerMapper {


//    UniversityControllerMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(UniversityControllerMapper.class); // proyekt isleyirse bunu sil

    UniversityResponseDto toResponseDto(UniversityServiceDto serviceDto);

    List<UniversityResponseDto> toResponseDtoList(List<UniversityServiceDto> serviceDto);


}
