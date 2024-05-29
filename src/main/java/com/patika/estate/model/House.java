package com.patika.estate.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class House extends Estate {
    private Integer floorNumber;
    private Integer flatNumber;

    public House(Long id, String name, String description, Long price, Integer squareMeter, Integer roomCount, Integer hallCount, Integer floorNumber, Integer flatNumber){
        super(id, name, description, price, squareMeter, roomCount, hallCount);
        this.floorNumber = floorNumber;
        this.flatNumber = flatNumber;
    }
}
