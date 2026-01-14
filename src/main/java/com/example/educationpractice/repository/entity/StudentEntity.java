package com.example.educationpractice.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "StudentEntity")
@Table(name = "student")
@DynamicUpdate
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id")
    private UniversityEntity university;

}
