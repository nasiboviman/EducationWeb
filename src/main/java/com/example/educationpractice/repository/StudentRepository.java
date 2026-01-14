package com.example.educationpractice.repository;

import com.example.educationpractice.repository.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>, JpaSpecificationExecutor<StudentEntity> {

StudentEntity findStudentById(Integer id);

}
