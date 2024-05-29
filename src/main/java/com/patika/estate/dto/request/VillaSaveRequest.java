package com.patika.estate.dto.request;
import com.patika.estate.model.Estate;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VillaSaveRequest extends Estate {
    private Integer floorCount;
    private boolean hasPool;

    public VillaSaveRequest(Long id, String name,String description, Long price, Integer squareMeter, Integer roomCount, Integer hallCount, Integer floorCount, boolean hasPool){
        super(id, name, description, price, squareMeter, roomCount, hallCount);
        this.floorCount = floorCount;
        this.hasPool = hasPool;
    }
}
