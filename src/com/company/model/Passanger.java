package com.company.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Passanger {
    @Id
    // aici am modificat
    @Column(name = "id")
    private UUID id;
    private String name;
    private String surname;

//    @OneToMany
//    @JoinTable(
//          name = "passanger_ticket",
//          joinColumns = @JoinColumn(name = "passanger_id"),
//          inverseJoinColumns = @JoinColumn(name = "ticket_id")
//    )
//    private Set<Ticket> tickets;
}
