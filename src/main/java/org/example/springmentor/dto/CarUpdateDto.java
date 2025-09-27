package org.example.springmentor.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CarUpdateDto {
    private Long id;

    @NotBlank(message = "Car name cannot be blank")
    private String carName;

    @NotNull(message = "Release year cannot be null")
    @Min(value = 2000, message = "Release year cannot be before 2000")
    private Integer releaseYear;

    @NotBlank(message = "Driver name cannot be blank")
    private String driverName;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be positive")
    private Integer price;
}
