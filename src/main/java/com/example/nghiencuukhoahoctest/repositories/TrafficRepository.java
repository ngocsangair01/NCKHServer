package com.example.nghiencuukhoahoctest.repositories;

import com.example.nghiencuukhoahoctest.models.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficRepository extends JpaRepository<Traffic,Integer> {
}
