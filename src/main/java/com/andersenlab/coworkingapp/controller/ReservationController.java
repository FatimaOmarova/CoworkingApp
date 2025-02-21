package com.andersenlab.coworkingapp.controller;

import com.andersenlab.coworkingapp.entity.Reservation;
import com.andersenlab.coworkingapp.dto.ReservationRequest;
import com.andersenlab.coworkingapp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/save")
    public ResponseEntity<String> addReservation(@RequestBody ReservationRequest request, @RequestHeader("role") String role) {
        if (!"CUSTOMER".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Only users can make reservations");
        }
        reservationService.saveReservation(request);
        return ResponseEntity.ok("Reservation added successfully");
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id, @RequestHeader("role") String role) {
        if (!"CUSTOMER".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Only users can delete reservations");
        }
        reservationService.deleteReservation(id);
        return ResponseEntity.ok("Reservation deleted successfully");
    }

    @GetMapping("/view/{userId}")
    public ResponseEntity<List<Reservation>> viewReservation(@PathVariable Long userId, @RequestHeader("role") String role) {
        if (!"CUSTOMER".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.ok(reservationService.viewReservationByUser(userId));
    }
}
