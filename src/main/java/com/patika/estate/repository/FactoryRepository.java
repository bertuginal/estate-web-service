package com.patika.estate.repository;


public class FactoryRepository {

    public static HouseRepository createHouseRepository() {
        return HouseRepository.getInstance();
    }

    public static SummerHouseRepository createSummerHouseRepository(){
        return SummerHouseRepository.getInstance();
    }

    public static VillaRepository createVillaRepository(){
        return VillaRepository.getInstance();
    }

}
