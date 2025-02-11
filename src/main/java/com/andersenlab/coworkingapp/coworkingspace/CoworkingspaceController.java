package com.andersenlab.coworkingapp.coworkingspace;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CoworkingspaceController {
    private final CoworkingspaceService coworkingspaceService;

    @PostMapping("save/coworkingspace")
    public void addCoworkingspace(@RequestBody Coworkingspace coworkingspace) {
        coworkingspaceService.saveCoworkingspace(coworkingspace);
    }

    @PostMapping("delete/coworkingspace/{id}")
    public void deleteCoworkingspace(@PathVariable Long id) {
        coworkingspaceService.deleteCoworkingspace(id);
    }

    @GetMapping("view/coworkingspace/all")
    public List<Coworkingspace> viewAllCoworkingspace() {
        return coworkingspaceService.viewAllCoworkingspace();
    }

    @GetMapping("view/coworkingspace/available")
    public List<Coworkingspace> viewAvailableCoworkingspace() {
        return coworkingspaceService.viewAvailableCoworkingspace();
    }
    @PostMapping("update/coworkingspace/id/{id}/type/{type}")
    public void updateCoworkingType(@PathVariable Long id,@PathVariable String type){
        coworkingspaceService.updateCoworkingspaceType(id, type);
    }

}
