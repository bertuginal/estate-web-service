package com.patika.estate.model;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SummerHouse extends Estate {
    private Integer floorCount;
    private boolean isInHousingEstate;

    public SummerHouse(Long id, String name, String description, Long price, Integer squareMeter, Integer roomCount, Integer hallCount, Integer floorCount, boolean isInHousingEstate){
        super(id, name, description, price, squareMeter, roomCount, hallCount);
        this.floorCount = floorCount;
        this.isInHousingEstate = isInHousingEstate;
    }
}
