package org.example.springmentor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springmentor.dto.CarDto;
import org.example.springmentor.dto.CarUpdateDto;
import org.example.springmentor.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public List<CarDto> getCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCar(@RequestBody CarUpdateDto carUpdateDto) {
        carService.createCar(carUpdateDto);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarDto updateValue(@PathVariable Long id, @RequestBody CarUpdateDto carUpdateDto) {
        return carService.updateCar(id, carUpdateDto);
    }
}
