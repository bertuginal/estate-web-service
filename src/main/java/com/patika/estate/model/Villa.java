package com.patika.estate.model;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Villa extends Estate {
    private Integer floorCount;
    private boolean hasPool;

    public Villa(Long id, String name, String description, Long price, Integer squareMeter, Integer roomCount, Integer hallCount, Integer floorCount, boolean hasPool){
        super(id, name, description, price, squareMeter, roomCount, hallCount);
        this.floorCount = floorCount;
        this.hasPool = hasPool;
    }

}
