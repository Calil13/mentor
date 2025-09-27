package org.example.springmentor.mapper;

import org.example.springmentor.dto.CarDto;
import org.example.springmentor.dto.CarUpdateDto;
import org.example.springmentor.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto toDto(CarEntity carEntity);

    CarEntity toEntity(CarDto carDto);

    CarEntity updateEntityFromDto(CarUpdateDto carUpdateDto);
}
