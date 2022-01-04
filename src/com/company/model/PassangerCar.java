package com.company.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class PassangerCar {
@Id
    private UUID id;
    private int seats;

  @Embedded
    private Document document;
}
