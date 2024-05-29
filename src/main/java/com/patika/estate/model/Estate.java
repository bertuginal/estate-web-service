package com.patika.estate.model;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estate {
    private Long id;
    private String name;
    private String description;
    private Long price;
    private Integer squareMeter;
    private Integer roomCount;
    private Integer hallCount;

}


