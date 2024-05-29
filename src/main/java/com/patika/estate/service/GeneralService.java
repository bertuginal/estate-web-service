package com.patika.estate.service;


import com.patika.estate.model.Estate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GeneralService {

    HouseService houseService = new HouseService();
    SummerHouseService summerHouseService = new SummerHouseService();
    VillaService villaService = new VillaService();

    public Long calculateHousesPrice(){
        return houseService.getAllList().stream()
                .map(Estate::getPrice)
                .reduce(0L, Long::sum);
    }

    public Long calculateSummerHousesPrice(){
        return summerHouseService.getAllList().stream()
                .map(Estate::getPrice)
                .reduce(0L, Long::sum);
    }

    public Long calculateVillasPrice(){
        return villaService.getAllList().stream()
                .map(Estate::getPrice)
                .reduce(0L, Long::sum);
    }

    public Long calculateEstatesAveragePrice(){
        return calculateHousesPrice() + calculateVillasPrice() + calculateSummerHousesPrice();
    }

    public Integer getSummerHousesAverageSquareMeter(){
        if(summerHouseService.getAllList().size() > 0) {
            return summerHouseService.getAllList().stream()
                    .map(Estate::getSquareMeter)
                    .reduce(0, Integer::sum) / summerHouseService.getAllList().size();
        } else {
            throw new NullPointerException();
        }
    }

    public Integer getHousesAverageSquareMeter(){
        if(houseService.getAllList().size() > 0) {
            return houseService.getAllList().stream()
                    .map(Estate::getSquareMeter)
                    .reduce(0, Integer::sum) / houseService.getAllList().size();
        } else {
            throw new NullPointerException();
        }
    }

    public Integer getVillasAverageSquareMeter(){
        if(villaService.getAllList().size() > 0) {
            return villaService.getAllList().stream()
                    .map(Estate::getSquareMeter)
                    .reduce(0, Integer::sum) / villaService.getAllList().size();
        } else {
            throw new NullPointerException();
        }
    }


    public Integer getAllResidencesAverageSquareMeter(){
        return (getHousesAverageSquareMeter() * houseService.getAllList().size() + getVillasAverageSquareMeter() * villaService.getAllList().size() + getSummerHousesAverageSquareMeter() * summerHouseService.getAllList().size()) / (summerHouseService.getAllList().size() + villaService.getAllList().size() + houseService.getAllList().size());
    }

    public List<Estate> estateListByRoomCountAndHallCount(Integer roomCount, Integer hallCount){
        List<Estate> estateList = new ArrayList<>();

        estateList.addAll(villaService.getAllList().stream()
                .filter(estate -> Objects.equals(estate.getRoomCount(), roomCount) && Objects.equals(estate.getHallCount(), hallCount))
                .toList());

        estateList.addAll(summerHouseService.getAllList().stream()
                .filter(estate -> Objects.equals(estate.getRoomCount(), roomCount) && Objects.equals(estate.getHallCount(), hallCount))
                .toList());

        estateList.addAll(houseService.getAllList().stream()
                .filter(estate -> Objects.equals(estate.getRoomCount(), roomCount) && Objects.equals(estate.getHallCount(), hallCount))
                .toList());

        return estateList;
    }



}
