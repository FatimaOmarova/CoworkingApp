package com.andersenlab.coworkingapp.controller;

import com.andersenlab.coworkingapp.entity.Coworkingspace;
import com.andersenlab.coworkingapp.service.CoworkingspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coworkingspace")
public class CoworkingspaceController {
    private final CoworkingspaceService coworkingspaceService;

    @PostMapping("/save")
    public ResponseEntity<String> addCoworkingspace(@RequestBody Coworkingspace coworkingspace, @RequestHeader("role") String role) {
        if (!"ADMIN".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }
        coworkingspaceService.saveCoworkingspace(coworkingspace);
        return ResponseEntity.ok("Coworking space added");
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteCoworkingspace(@PathVariable Long id, @RequestHeader("role") String role) {
        if (!"ADMIN".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }
        coworkingspaceService.deleteCoworkingspace(id);
        return ResponseEntity.ok("Coworking space deleted");
    }

    @GetMapping("/view/all")
    public ResponseEntity<List<Coworkingspace>> viewAllCoworkingspace(@RequestHeader("role") String role) {
        if (!"CUSTOMER".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.ok(coworkingspaceService.viewAllCoworkingspace());
    }

    @GetMapping("/view/available")
    public ResponseEntity<List<Coworkingspace>> viewAvailableCoworkingspace(@RequestHeader("role") String role) {
        if (!"CUSTOMER".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.ok(coworkingspaceService.viewAvailableCoworkingspace());
    }

    @PostMapping("/update/{id}/type/{type}")
    public ResponseEntity<String> updateCoworkingType(@PathVariable Long id, @PathVariable String type, @RequestHeader("role") String role) {
        if (!"ADMIN".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }
        coworkingspaceService.updateCoworkingspaceType(id, type);
        return ResponseEntity.ok("Coworking space updated");
    }
}
