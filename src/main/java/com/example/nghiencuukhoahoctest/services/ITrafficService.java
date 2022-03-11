package com.example.nghiencuukhoahoctest.services;

import com.example.nghiencuukhoahoctest.dtos.TrafficDTO;
import com.example.nghiencuukhoahoctest.models.Traffic;

public interface ITrafficService {
    Traffic createNewTraffic(TrafficDTO trafficDTO);
}
