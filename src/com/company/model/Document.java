package com.company.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Document {

    @Id
    private UUID id;
    private String series;
    private String number;

}
