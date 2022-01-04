package com.company.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Schedule {

    @Id
    private UUID id;
    private String code;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    @ManyToOne
    @JoinTable(
            name = "trainStation_departure",
            joinColumns = @JoinColumn(name = "trainStation_id"),
            inverseJoinColumns = @JoinColumn(name = "departure_id")
    )
    private TrainStation departure;


    @ManyToOne
    @JoinTable(
            name = "trainStation_arrival",
            joinColumns = @JoinColumn(name = "trainStation_id"),
            inverseJoinColumns = @JoinColumn(name = "arrival_id")
    )
    private TrainStation arrival;


    @OneToMany
    @JoinTable(
            name = "train_ticket",
            joinColumns = @JoinColumn(name = "train_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id")
    )
    private Set<Ticket> ticketSet;
}
