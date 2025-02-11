package com.andersenlab.coworkingapp.coworkingspace;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoworkingspaceRepository extends JpaRepository<Coworkingspace, Long> {
    List<Coworkingspace> findAllByAvailability(boolean b);

    @Modifying(clearAutomatically = true)
    @Query("update Coworkingspace c set c.type = :type where c.id = :id")
    void updateType(@Param(value = "id") Long id, @Param(value = "type") String type);
}
