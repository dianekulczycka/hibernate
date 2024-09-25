package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "drivers_license")

public class DriversLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String series;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "driversLicense")
    private Owner owner;

    public DriversLicense(String series) {
        this.series = series;
    }
}
