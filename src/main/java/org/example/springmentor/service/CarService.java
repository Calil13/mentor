package org.example.springmentor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springmentor.dto.CarDto;
import org.example.springmentor.entity.CarEntity;
import org.example.springmentor.mapper.CarMapper;
import org.example.springmentor.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public void createCar(CarDto carDto) {
        log.info("Car added: {}", carDto.getCarName());
        CarEntity carEntity = carMapper.toEntity(carDto);
        carMapper.toDto(carRepository.save(carEntity));
    }

    public List<CarDto> getAllCars() {
        log.info("Get all cars");
        return carRepository.findAll().stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    public CarDto getCarById(Long id) {
        log.info("Searching for a car by ID: {}", id);
        CarEntity carEntity = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found: " + id));
        return carMapper.toDto(carEntity);
    }


    public CarDto updateCar(Long id, CarDto carDto) {
        log.info("Car update: {}", id);
        CarEntity car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found: " + id));

        car.setCarName(carDto.getCarName());
        car.setReleaseYear(carDto.getReleaseYear());
        car.setDriverName(carDto.getDriverName());

        return carMapper.toDto(carRepository.save(car));
    }

    public void deleteCar(Long id) {
        log.info("Car delete: {}", id);
        carRepository.deleteById(id);
    }
}
