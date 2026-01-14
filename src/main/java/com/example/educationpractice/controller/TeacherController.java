package com.example.educationpractice.controller;

import com.example.educationpractice.controller.dto.*;
import com.example.educationpractice.mapper.TeacherControllerMapper;
import com.example.educationpractice.mapper.UniversityControllerMapper;
import com.example.educationpractice.service.TeacherService;
import com.example.educationpractice.service.UniversityService;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import com.example.educationpractice.service.dto.UniversityServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;



@AllArgsConstructor
@Controller
@RequestMapping("/teachers")
public class TeacherController {


    private final TeacherService teacherService;
    private final UniversityService universityService;
    private final TeacherControllerMapper teacherControllerMapper;
    private final UniversityControllerMapper universityControllerMapper;


    @GetMapping
    public ModelAndView search(ModelAndView modelAndView ,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false) String surname,
                                        @RequestParam(required = false) Integer age,
                                        @RequestParam(required = false) BigDecimal salary,
                                        @RequestParam (required = false, name = "university.id") Integer universityId

    )
    {
        List<TeacherServiceDto> teacherServiceDtoList = teacherService.getTeachers(
                name,
                surname,
                age,
                salary,
                universityId
        );


        List<UniversityServiceDto> universityServiceDtoList = universityService.getUniversities();
        List<TeacherResponseDto> teacherResponseDtoList = teacherControllerMapper.toResponseDtoList(teacherServiceDtoList);


        List<UniversityResponseDto> universityResponseDtoList = universityControllerMapper.toResponseDtoList(universityServiceDtoList);

        modelAndView.addObject("teachers", teacherResponseDtoList);
        modelAndView.addObject("universities", universityResponseDtoList);

        modelAndView.setViewName("teachers/index");


        return modelAndView;
    }


    @PostMapping("/action")
    public String actionPage(@RequestParam String action,
                             @ModelAttribute TeacherRequestDto teacherRequest){


        if ("delete".equalsIgnoreCase(action)){
            teacherService.deleteById(teacherRequest.getId());
        }
        else if ("create".equalsIgnoreCase(action)){

            TeacherServiceDto serviceDto =  teacherControllerMapper.toServiceDto(teacherRequest);
            teacherService.create(serviceDto);

        }

        return "redirect:/teachers";
    }




}
