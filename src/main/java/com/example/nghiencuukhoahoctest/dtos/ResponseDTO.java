package com.example.nghiencuukhoahoctest.dtos;

import com.example.nghiencuukhoahoctest.constant.ResponseMessageEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO<T> {
    private Integer status;
    private ResponseMessageEnum message;
    private T result;
}