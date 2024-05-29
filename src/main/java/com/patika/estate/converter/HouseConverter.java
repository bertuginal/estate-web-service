package com.patika.estate.converter;
import com.patika.estate.dto.request.HouseSaveRequest;
import com.patika.estate.model.House;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HouseConverter {
    public static House toHouse(HouseSaveRequest request) {
        return new House(request.getId(),request.getName(),request.getDescription(),request.getPrice(),request.getSquareMeter(),request.getRoomCount(),request.getHallCount(), request.getFloorNumber(),request.getFlatNumber());
    }
}
