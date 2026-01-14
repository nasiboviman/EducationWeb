package com.example.educationpractice.controller.dto;


import lombok.Data;

@Data
public class CommonResponseDto<T> {

    private T data;
    private String message;
    private String systemMessage;
    private int code;

    public CommonResponseDto(T data, String message, String systemMessage) {
        this.data = data;
        this.message = message;
        this.systemMessage = systemMessage;
    }

    public CommonResponseDto(T data, String message, int code) {

        this.data = data;
        this.message = message;
        this.code = code;

    }

    public CommonResponseDto(T data, String message, String systemMessage, int code) {
        this.data = data;
        this.message = message;
        this.systemMessage = systemMessage;
        this.code = code;
    }

    public CommonResponseDto(T data) {
        this.data = data;
    }

    public CommonResponseDto(String message, int code) {
        this.message = message;
        this.code = code;
    }




}
