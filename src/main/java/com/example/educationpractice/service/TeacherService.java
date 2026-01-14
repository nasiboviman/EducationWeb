package com.example.educationpractice.service;

import com.example.educationpractice.repository.TeacherRepository;
import com.example.educationpractice.repository.TeacherSpecification;
import com.example.educationpractice.repository.entity.StudentEntity;
import com.example.educationpractice.repository.entity.TeacherEntity;
import com.example.educationpractice.service.dto.StudentServiceDto;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import com.example.educationpractice.service.dto.mapper.StudentServiceMapper;
import com.example.educationpractice.service.dto.mapper.TeacherServiceMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TeacherService implements StudentServiceInter {



    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherServiceDto> getTeachers(String name,
                                               String surname,
                                               Integer age,
                                               BigDecimal salary,
                                               Integer universityId) {
        Specification<TeacherEntity> filter = TeacherSpecification.filter(name, surname, age, salary, universityId);

        List<TeacherEntity> list = teacherRepository.findAll(filter);

        return TeacherServiceMapper.INSTANCE.toServiceDtoList(list);
    }

    @Override
    public List<StudentServiceDto> getStudents(String name, String surname, Integer age, BigDecimal scholarship, Integer universityId) {
        return List.of();
    }

    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public StudentServiceDto create(StudentServiceDto studentServiceDto) {
        return null;
    }

    @Override
    public StudentServiceDto getStudentById(Integer id) {
        return null;
    }

    public TeacherServiceDto create(TeacherServiceDto teacherServiceDto) {
        TeacherEntity teacherEntity = TeacherServiceMapper.INSTANCE.toEntity(teacherServiceDto);
        teacherRepository.save(teacherEntity);
        return teacherServiceDto;
    }

    public TeacherServiceDto getTeacherById(Integer id) {

        TeacherEntity teacherEntity = teacherRepository.findTeacherById(id);

        return TeacherServiceMapper.INSTANCE.toServiceDto(teacherEntity);
    }

}
