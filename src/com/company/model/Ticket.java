package com.company.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ticket {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne
    private Passanger passanger;

    @ManyToOne
    private Schedule schedule;
}
