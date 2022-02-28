package com.example.nghiencuukhoahoctest.repositories;

import com.example.nghiencuukhoahoctest.models.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower,Integer> {
}
