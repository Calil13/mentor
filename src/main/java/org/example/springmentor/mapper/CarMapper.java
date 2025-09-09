package org.example.springmentor.mapper;

import org.example.springmentor.dto.CarDto;
import org.example.springmentor.entity.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto toDto(CarEntity carEntity) {
        return CarDto.builder()
                .id(carEntity.getId())
                .carName(carEntity.getCarName())
                .releaseYear(carEntity.getReleaseYear())
                .driverName(carEntity.getDriverName())
                .build();
    }

    public CarEntity toEntity(CarDto carDto) {
        return CarEntity.builder()
                .id(carDto.getId())
                .carName(carDto.getCarName())
                .releaseYear(carDto.getReleaseYear())
                .driverName(carDto.getDriverName())
                .build();
    }
}
