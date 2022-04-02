package com.example.test.services.imp;

import com.example.test.dtos.TrafficDTO;
import com.example.test.exceptions.BadRequestException;
import com.example.test.exceptions.NotFoundException;
import com.example.test.models.Traffic;
import com.example.test.models.User;
import com.example.test.repositories.TrafficRepository;
import com.example.test.repositories.UserRepositories;
import com.example.test.services.ITrafficService;
import com.example.test.utils.ConvertDTOToDAO;
import com.example.test.utils.UploadFile;
import com.github.slugify.Slugify;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class TrafficServiceImp implements ITrafficService {
    @Autowired
    private TrafficRepository trafficRepository;

    @Autowired
    private UploadFile uploadFile;

    @Autowired
    private SendMailServiceImp sendMailServiceImp;


    @Autowired
    private Slugify slugify;

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public Traffic createNewTraffic(TrafficDTO trafficDTO, Integer idUser) {
        Optional<User> user = userRepositories.findById(idUser);
        if(user.isEmpty()){
            throw new NotFoundException("No user.");
        }
        Traffic oldTraffic = trafficRepository.findByLicensePlate(trafficDTO.getLicensePlate());
        if(oldTraffic != null){
            throw new BadRequestException("Traffic already exists");
        }
        Traffic traffic = new Traffic();
        ConvertDTOToDAO.fromTrafficDTOToTraffic(trafficDTO,traffic);
        String randomCode = RandomStringUtils.randomAlphanumeric(10);
        String code = trafficDTO.getLicensePlate().concat("-").concat(randomCode);
        slugify = slugify.withTransliterator(true);
        traffic.setCode(slugify.slugify(code));
        traffic.setUser(user.get());
//        sendMailServiceImp.sendMailWithText("Hello","Bạn thêm thành công phương tiện có biển số xe là:"+trafficDTO.getLicensePlate(),user.get().getEmail() );

        return trafficRepository.save(traffic);
    }


    @Override
    public Traffic deleteTrafficById(Integer idUser,Integer idTraffic) {
        Optional<User> user = userRepositories.findById(idUser);
        if (user.isEmpty()){
            throw new NotFoundException("No User");
        }
        Optional<Traffic> oldTraffic = trafficRepository.findById(idTraffic);
        if(oldTraffic.isEmpty()){
            throw new NotFoundException("Biển số xe không tồn tại trong dữ liệu");
        }
        System.out.println(3);
        trafficRepository.deleteById(idTraffic);
        System.out.println(4);
        return oldTraffic.get();
    }

    @Override
    public List<Traffic> getAllTrafficByIdUser(Integer idUser) {
        System.out.println(1);
        Optional<User> user = userRepositories.findById(idUser);
        System.out.println(2);
        if(user.isEmpty()){
            throw new NotFoundException("No user.");
        }
        System.out.println(3);
        List<Traffic> traffics = trafficRepository.findAllByUser(user.get());
        System.out.println(4);
        if (traffics.size() == 0) {
            throw new NotFoundException("No traffic");
        }
        System.out.println(5);
        return traffics;
    }

    @Override
    public Set<Traffic> getAllTraffic() {
        Set<Traffic> traffics = new HashSet<>(trafficRepository.findAll());
        if(traffics.size() == 0){
            throw new NotFoundException("Null");
        }
        return traffics;
    }

    @Override
    public Traffic editTrafficById(TrafficDTO trafficDTO, Integer idTraffic) {
        Optional<Traffic> traffic = trafficRepository.findById(idTraffic);
        if(traffic.isEmpty()){
            throw new NotFoundException("No traffic");
        }
        return trafficRepository.save(ConvertDTOToDAO.fromTrafficDTOToTraffic(trafficDTO,traffic.get()));
    }

    @Override
    public Traffic editAvatarTrafficById(MultipartFile file, Integer idTraffic) {
        Optional<Traffic> traffic = trafficRepository.findById(idTraffic);
        if(traffic.isEmpty()){
            throw new NotFoundException("Id không tồn tại.");
        }
        traffic.get().setAvatar(uploadFile.getUrlFromFile(file));
        return trafficRepository.save(traffic.get());
    }
}
