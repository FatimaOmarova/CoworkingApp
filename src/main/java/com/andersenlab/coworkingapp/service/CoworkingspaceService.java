package com.andersenlab.coworkingapp.service;


import com.andersenlab.coworkingapp.entity.Coworkingspace;
import com.andersenlab.coworkingapp.repository.CoworkingspaceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoworkingspaceService {
    private final CoworkingspaceRepository coworkingspaceRepository;

    public void saveCoworkingspace(Coworkingspace coworkingspace) {
        coworkingspaceRepository.save(coworkingspace);
    }

    public void deleteCoworkingspace(Long id) {
        coworkingspaceRepository.deleteById(id);
    }

    public List<Coworkingspace> viewAllCoworkingspace() {
        return coworkingspaceRepository.findAll();
    }

    public List<Coworkingspace> viewAvailableCoworkingspace() {
        return coworkingspaceRepository.findAllByAvailability(true);

    }
    @Transactional
    public void updateCoworkingspaceType(Long id, String type) {
        coworkingspaceRepository.updateType(id, type);
    }

}
