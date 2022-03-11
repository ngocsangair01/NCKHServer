package com.example.nghiencuukhoahoctest.repositories;

import com.example.nghiencuukhoahoctest.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
