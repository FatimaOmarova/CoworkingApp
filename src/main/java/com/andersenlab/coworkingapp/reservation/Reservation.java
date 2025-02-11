package com.andersenlab.coworkingapp.reservation;


import com.andersenlab.coworkingapp.coworkingspace.Coworkingspace;
import com.andersenlab.coworkingapp.customer.Customer;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName = "id")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="coworkingspace_id", referencedColumnName = "id")
    private Coworkingspace coworkingspace;
    private Date date;
    private Time startTime;
    private Time endTime;
}
