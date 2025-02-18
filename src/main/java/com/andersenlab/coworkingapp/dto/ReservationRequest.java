package com.andersenlab.coworkingapp.dto;


import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class ReservationRequest {
    private Long userId;
    private Long coworkingspaceId;
    private Date date;
    private Time startTime;
    private Time endTime;
}
