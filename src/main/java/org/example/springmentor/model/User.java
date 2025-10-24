package org.example.springmentor.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String name;
    private List<Country> country;
}
