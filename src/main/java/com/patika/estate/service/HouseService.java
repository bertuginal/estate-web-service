package com.patika.estate.service;
import com.patika.estate.converter.HouseConverter;
import com.patika.estate.dto.request.HouseSaveRequest;
import com.patika.estate.model.House;
import com.patika.estate.repository.HouseRepository;
import com.patika.estate.repository.FactoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class HouseService {
    private HouseRepository houseRepository = FactoryRepository.createHouseRepository();


    public void save(HouseSaveRequest request) throws ClassNotFoundException{

        Optional<House> foundHouse = houseRepository.findById(request.getId());

        if (foundHouse.isPresent()) {
            log.error("HOUSE_ALREADY_EXIST");
            throw new ClassNotFoundException();
        }

        House house = HouseConverter.toHouse(request);

        houseRepository.create(house);

        log.info("House has been created! ID: {}", house.getId() + " House's name: " + house.getName());
    }

    public List<House> getAllList() {
        return houseRepository.getHouseList();
    }



}
