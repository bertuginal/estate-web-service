package com.patika.estate.converter;

import com.patika.estate.dto.request.SummerHouseSaveRequest;
import com.patika.estate.model.SummerHouse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SummerHouseConverter {

    public static SummerHouse toSummerHouse(SummerHouseSaveRequest request) {
        return new SummerHouse(request.getId(),request.getName(),request.getDescription(),request.getPrice(),request.getSquareMeter(),request.getRoomCount(),request.getHallCount(),request.getFloorCount(), request.isInHousingEstate());
    }
}
