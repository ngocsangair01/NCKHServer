package com.example.test.repositories;

import com.example.test.models.Borrower;
import com.example.test.models.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower,Integer> {
    Optional<Borrower> findByTrafficAndCode(Traffic traffic, String codeUser);
    Set<Borrower> findAllByTraffic(Traffic traffic);
    Borrower deleteBorrowerById(Integer idBorrower);
    Borrower findByCode(String code);
}
