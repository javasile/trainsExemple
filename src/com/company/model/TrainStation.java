package com.company.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;


    @Entity
    @Data
public class TrainStation {

        @Id
    private UUID id;
    private String name;
    private String code;
    private int line;
    private String rout;

    @ManyToOne
        private Company company;

}
