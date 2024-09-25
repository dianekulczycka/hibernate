package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "words")

public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String value;

    public Word(String value) {
        this.value = value;
    }
}
