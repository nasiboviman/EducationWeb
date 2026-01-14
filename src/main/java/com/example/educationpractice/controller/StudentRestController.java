package com.example.educationpractice.controller;

import com.example.educationpractice.controller.dto.CommonResponseDto;
import com.example.educationpractice.controller.dto.StudentRequestDto;
import com.example.educationpractice.controller.dto.StudentResponseDto;
import com.example.educationpractice.mapper.StudentControllerMapper;
import com.example.educationpractice.service.StudentService;
import com.example.educationpractice.service.StudentServiceInter;
import com.example.educationpractice.service.dto.StudentServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(originPatterns = "*",allowedHeaders = "*")
@AllArgsConstructor
public class StudentRestController {

    private final StudentServiceInter studentService;
    private final StudentControllerMapper studentControllerMapper;

    private final Logger LOG = Logger.getLogger(StudentRestController.class.getName()); //scanner-den ferqi ancaq fayla yazir



    @GetMapping(produces = {"application/json", "application/xml"})
    public CommonResponseDto<List<StudentResponseDto>> getStudents(
                                        @RequestParam(required = false) String name,
                                         @RequestParam(required = false) String surname,
                                        @RequestParam(required = false) Integer age,
                                        @RequestParam(required = false) BigDecimal scholarship,
                                        @RequestParam (required = false, name = "universityId") Integer universityId

                                        )
    {
        List<StudentServiceDto> studentServiceDtoList = studentService.getStudents(
                name,
                surname,
                age,
                scholarship,
                universityId
        );



        return new CommonResponseDto<>(studentControllerMapper.toResponseDtoList(studentServiceDtoList));
    }

    @GetMapping("/{id}")
    public CommonResponseDto<StudentResponseDto> getStudentById(@PathVariable Integer id) {
        StudentServiceDto studentServiceDto = studentService.getStudentById(id);

        return new CommonResponseDto<>(studentControllerMapper.toResponseDto(studentServiceDto));
    }


    @RequestMapping(method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
    public CommonResponseDto<StudentResponseDto> insert(@RequestBody StudentRequestDto studentRequest){


     StudentServiceDto serviceDto =  studentControllerMapper.toServiceDto(studentRequest);
     StudentServiceDto createdStudentServiceDto = studentService.create(serviceDto);


        return new CommonResponseDto<>(studentControllerMapper.toResponseDto(createdStudentServiceDto),"Successfully inserted!", 0);
    }





    @PutMapping("/{id}")
    public CommonResponseDto<StudentResponseDto>  update(@PathVariable Integer id, @RequestBody StudentRequestDto studentRequest){

        try {
            StudentServiceDto serviceDto = studentControllerMapper.toServiceDto(studentRequest);
            serviceDto.setId(id);
            StudentServiceDto createdStudentServiceDto = studentService.create(serviceDto);

            return new CommonResponseDto<>(studentControllerMapper.toResponseDto(createdStudentServiceDto),"Successfully updated!", 0);

        }
        catch (Exception ex) {

            LOG.log(Level.SEVERE, "error occurred on student update", ex);
            return new CommonResponseDto<>(null,"Something went wrong!", ex.getMessage(),-100);

        }

    }




    @DeleteMapping("/{id}")
    public CommonResponseDto<StudentResponseDto>  delete(@PathVariable Integer id){

        studentService.deleteById(id);

        return new CommonResponseDto<>(new StudentResponseDto(id), "Successfully deleted!", 0);
    }





}
