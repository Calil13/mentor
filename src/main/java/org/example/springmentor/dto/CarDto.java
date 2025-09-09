package org.example.springmentor.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private Long id;
    private String carName;
    private int releaseYear;
    private String driverName;
}
