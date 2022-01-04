package com.company.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Train {
    @Id
    private UUID id;
    private String name;

    @OneToMany
    @JoinTable(
            name = "train_passangerCar",
            joinColumns = @JoinColumn(name = "train_id"),
            inverseJoinColumns = @JoinColumn(name = "passangerCar_id")
    )
    private List<PassangerCar> passangerCarList;

    @Embedded
    private Document document;
}
