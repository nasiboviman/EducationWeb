package com.example.educationpractice.controller;

import com.example.educationpractice.controller.dto.CommonResponseDto;
import com.example.educationpractice.controller.dto.TeacherRequestDto;
import com.example.educationpractice.controller.dto.TeacherResponseDto;
import com.example.educationpractice.mapper.TeacherControllerMapper;
import com.example.educationpractice.service.TeacherService;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin(originPatterns = "*",allowedHeaders = "*")
@AllArgsConstructor
public class TeacherRestController {

    private final TeacherService teacherService;
    private final TeacherControllerMapper teacherControllerMapper;

    private final Logger LOG = Logger.getLogger(TeacherRestController.class.getName()); //scanner-den ferqi ancaq fayla yazir



    @GetMapping(produces = {"application/json", "application/xml"})
    public CommonResponseDto<List<TeacherResponseDto>> getTeachers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) BigDecimal salary,
            @RequestParam (required = false, name = "universityId") Integer universityId

    )
    {
        List<TeacherServiceDto> teacherServiceDtoList = teacherService.getTeachers(
                name,
                surname,
                age,
                salary,
                universityId
        );



        return new CommonResponseDto<>(teacherControllerMapper.toResponseDtoList(teacherServiceDtoList));
    }

    @GetMapping("/{id}")
    public CommonResponseDto<TeacherResponseDto> getTeacherById(@PathVariable Integer id) {
        TeacherServiceDto teacherServiceDto = teacherService.getTeacherById(id);

        return new CommonResponseDto<>(teacherControllerMapper.toResponseDto(teacherServiceDto));
    }


    @RequestMapping(method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
    public CommonResponseDto<TeacherResponseDto> insert(@RequestBody TeacherRequestDto teacherRequest){


        TeacherServiceDto serviceDto =  teacherControllerMapper.toServiceDto(teacherRequest);
        TeacherServiceDto createdTeacherServiceDto = teacherService.create(serviceDto);


        return new CommonResponseDto<>(teacherControllerMapper.toResponseDto(createdTeacherServiceDto),"Successfully inserted!", 0);
    }





    @PutMapping("/{id}")
    public CommonResponseDto<TeacherResponseDto>  update(@PathVariable Integer id, @RequestBody TeacherRequestDto teacherRequest){

        try {
            TeacherServiceDto serviceDto = teacherControllerMapper.toServiceDto(teacherRequest);
            serviceDto.setId(id);
            TeacherServiceDto createdTeacherServiceDto = teacherService.create(serviceDto);

            return new CommonResponseDto<>(teacherControllerMapper.toResponseDto(createdTeacherServiceDto),"Successfully updated!", 0);

        }
        catch (Exception ex) {

            LOG.log(Level.SEVERE, "error occurred on student update", ex);
            return new CommonResponseDto<>(null,"Something went wrong!", ex.getMessage(),-100);

        }

    }




    @DeleteMapping("/{id}")
    public CommonResponseDto<TeacherResponseDto>  delete(@PathVariable Integer id){

        teacherService.deleteById(id);

        return new CommonResponseDto<>(new TeacherResponseDto(id), "Successfully deleted!", 0);
    }





}
