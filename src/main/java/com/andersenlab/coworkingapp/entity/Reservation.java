package com.andersenlab.coworkingapp.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="coworkingspace_id", referencedColumnName = "id")
    private Coworkingspace coworkingspace;
    private Date date;
    private Time startTime;
    private Time endTime;
}
