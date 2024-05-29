package com.patika.estate.service;
import com.patika.estate.converter.VillaConverter;
import com.patika.estate.dto.request.VillaSaveRequest;
import com.patika.estate.model.Villa;
import com.patika.estate.repository.FactoryRepository;
import com.patika.estate.repository.VillaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class VillaService {
    private VillaRepository villaRepository = FactoryRepository.createVillaRepository();;

    public void save(VillaSaveRequest request) throws ClassNotFoundException{

        Optional<Villa> foundSummerHouse = villaRepository.findById(request.getId());

        if (foundSummerHouse.isPresent()) {
            log.error("VILLA_ALREADY_EXIST");
            throw new ClassNotFoundException();
        }

        Villa villa = VillaConverter.toVilla(request);

        villaRepository.save(villa);

        log.info("Villa has been created! ID: {}", villa.getId() + " Villa's name: " + villa.getName());
    }

    public List<Villa> getAllList() {
        return villaRepository.getAll();
    }

}
