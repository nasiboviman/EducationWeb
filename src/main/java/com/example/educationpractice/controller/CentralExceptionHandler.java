package com.example.educationpractice.controller;


import com.example.educationpractice.controller.dto.CommonResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralExceptionHandler {


    Logger LOG = LoggerFactory.getLogger(CentralExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponseDto<Object>> onException(Exception ex){

        LOG.error( "Something went wrong", ex);

        CommonResponseDto<Object> CommonResponseDto = new CommonResponseDto<>(null,"Something went wrong!",ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(CommonResponseDto);

    }



}
