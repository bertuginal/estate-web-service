package com.patika.estate.repository;
import com.patika.estate.model.SummerHouse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SummerHouseRepository {

    private static SummerHouseRepository instance;
    private List<SummerHouse> summerHouseList = new ArrayList<>();

    public void save(SummerHouse summerHouse) {
        summerHouseList.add(summerHouse);
    }

    public List<SummerHouse> getAll() {
        return summerHouseList;
    }

    public Optional<SummerHouse> findById(Long id) {
        return getAll().stream()
                .filter(summerHouse -> summerHouse.getId().equals(id))
                .findFirst();
    }

    public static SummerHouseRepository getInstance() {
        if (instance == null) {
            synchronized (SummerHouseRepository.class) {
                if (instance == null) {
                    instance = new SummerHouseRepository();
                }
            }
        }
        return instance;
    }
}
