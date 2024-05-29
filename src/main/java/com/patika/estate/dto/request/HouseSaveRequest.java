package com.patika.estate.dto.request;
import com.patika.estate.model.Estate;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HouseSaveRequest extends Estate {
    private Integer floorNumber;
    private Integer flatNumber;

    public HouseSaveRequest(Long id, String name, String description, Long price, Integer squareMeter, Integer roomCount, Integer hallCount, Integer floorNumber, Integer flatNumber){
        super(id, name, description, price, squareMeter, roomCount, hallCount);
        this.floorNumber = floorNumber;
        this.flatNumber = flatNumber;
    }
}
