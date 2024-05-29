package com.patika.estate.converter;
import com.patika.estate.dto.request.VillaSaveRequest;
import com.patika.estate.model.Villa;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VillaConverter {
    public static Villa toVilla(VillaSaveRequest request) {
        return new Villa(request.getId(),request.getName(),request.getDescription(), request.getPrice(),request.getSquareMeter(),request.getRoomCount(),request.getHallCount(), request.getFloorCount(),request.isHasPool());
    }
}
