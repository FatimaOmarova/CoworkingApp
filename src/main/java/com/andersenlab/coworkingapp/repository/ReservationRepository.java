package com.andersenlab.coworkingapp.repository;

import com.andersenlab.coworkingapp.entity.User;
import com.andersenlab.coworkingapp.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUser(User user);

    List<Reservation> findByUserId(Long customerId);
}
