package com.example.nghiencuukhoahoctest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrafficDTO {
    private String name;
    private String type;
    private String licensePlate;
    private String color;
    private String brand;
    private Integer code;
    private String avatar;
}
