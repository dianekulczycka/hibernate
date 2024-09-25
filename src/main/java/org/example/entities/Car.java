package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.CarType;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="cars")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String model;

    @Enumerated(EnumType.STRING)
    private CarType type;

    private double power;
    private double price;
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;

    public Car(String model, CarType type, double power, double price, Owner owner, int year) {
        this.model = model;
        this.type = type;
        this.power = power;
        this.price = price;
        this.owner = owner;
        this.year = year;
    }
}
