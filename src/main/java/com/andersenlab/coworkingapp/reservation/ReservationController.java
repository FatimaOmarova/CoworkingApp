package com.andersenlab.coworkingapp.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("save/reservation")
    public void addReservation(@RequestBody ReservationRequest request){
        reservationService.saveReservation(request);
    }
    @PostMapping("delete/reservation/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
    }

    @GetMapping("view/reservation")
    public List<Reservation>viewReservation(){
        return reservationService.viewReservation();
    }
}
