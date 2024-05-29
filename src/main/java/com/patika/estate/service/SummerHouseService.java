package com.patika.estate.service;
import com.patika.estate.converter.SummerHouseConverter;
import com.patika.estate.dto.request.SummerHouseSaveRequest;
import com.patika.estate.model.SummerHouse;
import com.patika.estate.repository.FactoryRepository;
import com.patika.estate.repository.SummerHouseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class SummerHouseService {

    private SummerHouseRepository summerHouseRepository = FactoryRepository.createSummerHouseRepository();;

    public void save(SummerHouseSaveRequest request) throws ClassNotFoundException{

        Optional<SummerHouse> foundSummerHouse = summerHouseRepository.findById(request.getId());

        if (foundSummerHouse.isPresent()) {
            log.error("SUMMER_HOUSE_ALREADY_EXIST");
            throw new ClassNotFoundException();
        }

        SummerHouse summerHouse = SummerHouseConverter.toSummerHouse(request);

        summerHouseRepository.save(summerHouse);

        log.info("Summerhouse has been created! ID: {}", summerHouse.getId() + " Summerhouse's name: " + summerHouse.getName());
    }

    public List<SummerHouse> getAllList() {
        return summerHouseRepository.getAll();
    }


}
