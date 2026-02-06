package ru.sicampus.bootcamp2026.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sicampus.bootcamp2026.dto.EmployeeDTO;
import ru.sicampus.bootcamp2026.dto.PlaceDTO;
import ru.sicampus.bootcamp2026.repository.PlaceRepository;
import ru.sicampus.bootcamp2026.service.PlaceService;

import java.util.List;

@RestController
@RequestMapping("/api/place")
@RequiredArgsConstructor

public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public List<PlaceDTO> getAlPlaces(){
        return placeService.getAllPlaces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceDTO> getPlaceById(@PathVariable Long id){
        return ResponseEntity.ok(placeService.getPlaceById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PlaceDTO> createPlace(@RequestBody PlaceDTO placeDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(placeService.createPlace(placeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaceDTO> updatePlace(@PathVariable Long id, @RequestBody PlaceDTO placeDTO){
        return ResponseEntity.ok(placeService.updatePlace(id, placeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id){
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }
}
