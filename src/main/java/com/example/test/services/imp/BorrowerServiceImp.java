package com.example.test.services.imp;

import com.example.test.dtos.BorrowerDTO;
import com.example.test.exceptions.BadRequestException;
import com.example.test.exceptions.NotFoundException;
import com.example.test.models.Borrower;
import com.example.test.models.Traffic;
import com.example.test.repositories.BorrowerRepository;
import com.example.test.repositories.TrafficRepository;
import com.example.test.services.IBorrowerService;
import com.example.test.utils.ConvertDTOToDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BorrowerServiceImp implements IBorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Autowired
    private TrafficRepository trafficRepository;

    @Override
    public Borrower createBorrower(BorrowerDTO borrowerDTO, Integer idTraffic) {
        Optional<Traffic> traffic = trafficRepository.findById(idTraffic);
        if (traffic.isEmpty()){
            throw new NotFoundException("No traffic");
        }
        System.out.println(3);
        Optional<Borrower> oldBorrower = borrowerRepository.findByTrafficAndCode(traffic.get(), borrowerDTO.getCode());
        System.out.println(4);
        Borrower borrower = new Borrower();
        if(oldBorrower.isPresent()){
            throw new BadRequestException("borrower already exists");
        }
        ConvertDTOToDAO.fromBorrowerDTOToBorrower(borrowerDTO,borrower);
        borrower.setTraffic(traffic.get());
        return borrowerRepository.save(borrower);
    }

    @Override
    public Set<Borrower> getAllByIdTraffic(Integer idTraffic) {
        Optional<Traffic> traffic = trafficRepository.findById(idTraffic);
        Set<Borrower> borrowers = new HashSet<>(borrowerRepository.findAllByTraffic(traffic.get()));
        if(borrowers.isEmpty()){
            throw new NotFoundException("No borrower");
        }
        return borrowers;
    }


    @Override
    public Borrower deleteById(String codeBorrower,Integer idTraffic) {
        Optional<Traffic> traffic = trafficRepository.findById(idTraffic);
        if (traffic.isEmpty()){
            throw new NotFoundException("No traffic");
        }
        Borrower borrower = borrowerRepository.findByCode(codeBorrower);
        if(borrower == null){
            throw new NotFoundException("No Borrower");
        }
//        borrowerRepository.findByTraffic(traffic.get());
        borrowerRepository.delete(borrower);
        return borrower;
    }

}
