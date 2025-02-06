package com.andersenlab.coworkingapp.reservation;

import com.andersenlab.coworkingapp.coworkingspace.Coworkingspace;
import com.andersenlab.coworkingapp.coworkingspace.CoworkingspaceRepository;
import com.andersenlab.coworkingapp.customer.Customer;
import com.andersenlab.coworkingapp.customer.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final CoworkingspaceRepository coworkingspaceRepository;

    @Transactional
    public void saveReservation(ReservationRequest request){
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(()-> new RuntimeException("Customer not found"));
        Coworkingspace coworkingspace = coworkingspaceRepository.findById(request.getCoworkingspaceId())
                .orElseThrow(() -> new RuntimeException("Coworkingspace not found"));
        if(!coworkingspace.isAvailability()){
            throw new RuntimeException("Coworkingspace is not available");
        }
        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
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
}
