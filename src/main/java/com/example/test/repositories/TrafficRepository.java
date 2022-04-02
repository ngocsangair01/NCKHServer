package com.example.test.repositories;

import com.example.test.models.Traffic;
import com.example.test.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrafficRepository extends JpaRepository<Traffic,Integer> {
    Traffic findByLicensePlate(String licensePlate);
    Traffic deleteByLicensePlate(String licensePlate);
    List<Traffic> findAllByUser(User user);
    void deleteById(Integer idTraffic);

}
