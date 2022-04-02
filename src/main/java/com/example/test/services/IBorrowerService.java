package com.example.test.services;

import com.example.test.dtos.BorrowerDTO;
import com.example.test.models.Borrower;

import java.util.Set;

public interface IBorrowerService {
    Borrower createBorrower(BorrowerDTO borrowerDTO, Integer idTraffic);
    Set<Borrower> getAllByIdTraffic(Integer idTraffic);
    Borrower deleteById(String codeBorrower,Integer idTraffic);

}
