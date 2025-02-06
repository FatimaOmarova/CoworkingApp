package com.andersenlab.coworkingapp.reservation;


import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class ReservationRequest {
    private Long customerId;
    private Long coworkingspaceId;
    private Date date;
    private Time startTime;
    private Time endTime;
}
