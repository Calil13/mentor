package org.example.springmentor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springmentor.dto.CarDto;
import org.example.springmentor.dto.CarUpdateDto;
import org.example.springmentor.entity.CarEntity;
import org.example.springmentor.exception.CarNotFoundException;
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

    public void createCar(CarUpdateDto carUpdateDto) {
        log.info("Car added: {}", carUpdateDto.getCarName());
        CarEntity carEntity = carMapper.updateEntityFromDto(carUpdateDto);
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
                .orElseThrow(() -> new CarNotFoundException("Car not found: " + id));
        return carMapper.toDto(carEntity);
    }


    public CarDto updateCar(Long id, CarUpdateDto carUpdateDto) {
        log.info("Car update: {}", id);
        CarEntity car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found: " + id));

        if (carUpdateDto.getCarName() != null) {
            car.setCarName(carUpdateDto.getCarName());
        }
        if (carUpdateDto.getReleaseYear() != null) {
            car.setReleaseYear(carUpdateDto.getReleaseYear());
        }
        if (carUpdateDto.getDriverName() != null ) {
            car.setDriverName(carUpdateDto.getDriverName());
        }
        if (carUpdateDto.getPrice() != null) {
            car.setPrice(carUpdateDto.getPrice());
        }

        carRepository.save(car);

        return carMapper.toDto(carRepository.save(car));
    }

    public void deleteCar(Long id) {
        log.info("Car delete: {}", id);
        carRepository.deleteById(id);
    }
}
