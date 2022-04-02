package com.example.test.controllers;

import com.example.test.bases.BaseController;
import com.example.test.dtos.BorrowerDTO;
import com.example.test.dtos.TrafficDTO;
import com.example.test.models.Traffic;
import com.example.test.services.ITrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/traffics")
public class TrafficController extends BaseController<Traffic> {
    @Autowired
    private ITrafficService trafficService;

    @PostMapping("/post/{idUser}")
    public ResponseEntity<?> createNewTraffic(@RequestBody TrafficDTO trafficDTO, @PathVariable( name = "idUser") Integer idUser){
        return this.resSuccess(trafficService.createNewTraffic(trafficDTO, idUser));
    }

    @DeleteMapping("/delete/{idUser}/{idTraffic}")
    @Transactional
    public ResponseEntity<?> deleteTrafficById(@PathVariable(name ="idUser") Integer idUser,
                                               @PathVariable(name ="idTraffic") Integer idTraffic ){
        return this.resSuccess(trafficService.deleteTrafficById(idUser,idTraffic));
    }

    @GetMapping("/get-all-traffic-by-id-user/{idUser}")
    public ResponseEntity<?> getAllTrafficByIdUser(@PathVariable(name="idUser") Integer idUser){
        return this.resListSuccess(trafficService.getAllTrafficByIdUser(idUser));
    }

    @GetMapping("/get-all-traffic")
    public ResponseEntity<?> getAllTraffic( ){
        return this.resSetSuccess(trafficService.getAllTraffic());
    }

    @PatchMapping("/edit-traffic-by-Id/{idTraffic}")
    public ResponseEntity<?> editTrafficById(@RequestBody TrafficDTO trafficDTO ,@PathVariable(name = "idTraffic" ) Integer idTraffic){
        return  this.resSuccess(trafficService.editTrafficById(trafficDTO,idTraffic));
    }

    @PatchMapping("/edit-avatar-traffic-by-id/{idTraffic}")
    public ResponseEntity<?> editAvatarTrafficById(@RequestParam("avatarTraffic")MultipartFile file, @PathVariable(name = "idTraffic") Integer idTraffic){
        return this.resSuccess(trafficService.editAvatarTrafficById(file,idTraffic));
    }

}
