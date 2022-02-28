package com.example.nghiencuukhoahoctest.repositories;

import com.example.nghiencuukhoahoctest.models.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time,Integer> {
}
