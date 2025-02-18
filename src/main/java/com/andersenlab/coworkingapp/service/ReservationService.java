package com.andersenlab.coworkingapp.service;

import com.andersenlab.coworkingapp.entity.Coworkingspace;
import com.andersenlab.coworkingapp.entity.Reservation;
import com.andersenlab.coworkingapp.repository.CoworkingspaceRepository;
import com.andersenlab.coworkingapp.entity.User;
import com.andersenlab.coworkingapp.repository.UserRepository;
import com.andersenlab.coworkingapp.repository.ReservationRepository;
import com.andersenlab.coworkingapp.dto.ReservationRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final CoworkingspaceRepository coworkingspaceRepository;

    @Transactional
    public void saveReservation(ReservationRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));
        Coworkingspace coworkingspace = coworkingspaceRepository.findById(request.getCoworkingspaceId())
                .orElseThrow(() -> new RuntimeException("Coworkingspace not found"));
        if(!coworkingspace.isAvailability()){
            throw new RuntimeException("Coworkingspace is not available");
        }
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setCoworkingspace(coworkingspace);
        reservation.setDate(request.getDate());
        reservation.setStartTime(request.getStartTime());
        reservation.setEndTime(request.getEndTime());

        reservationRepository.save(reservation);
        coworkingspace.setAvailability(false);
        coworkingspaceRepository.save(coworkingspace);
    }
    @Transactional
    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }
    public List<Reservation> viewReservation(){
        return reservationRepository.findAll();
    }

    public List<Reservation> viewReservationByUser(Long userId) {
        return reservationRepository.findByUserId(userId);
    }
}
