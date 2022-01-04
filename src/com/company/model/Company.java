package com.company.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Company {
    @Id
    private UUID id;
    private String name;
    private String code;

    @OneToMany
    @JoinTable(
            name = "company_train",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "train_id")
    )
    private List<Train> trainList;

}
