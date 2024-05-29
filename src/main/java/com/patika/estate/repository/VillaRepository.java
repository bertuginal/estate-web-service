package com.patika.estate.repository;
import com.patika.estate.model.Villa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VillaRepository {
    private static VillaRepository instance;
    private List<Villa> villaList = new ArrayList<>();

    public void save(Villa summerHouse) {
        villaList.add(summerHouse);
    }

    public List<Villa> getAll() {
        return villaList;
    }

    public Optional<Villa> findById(Long id) {
        return getAll().stream()
                .filter(villa -> villa.getId().equals(id))
                .findFirst();
    }

    public static VillaRepository getInstance() {
        if (instance == null) {
            synchronized (VillaRepository.class) {
                if (instance == null) {
                    instance = new VillaRepository();
                }
            }
        }
        return instance;
    }
}
