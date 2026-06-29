package com.keydan.keyblooms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keydan.keyblooms.model.Plant;
import com.keydan.keyblooms.service.PlantService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@Slf4j
public class PlantController {

    private final PlantService plantService;

    @GetMapping("/plants")
    public ResponseEntity<List<Plant>> getAllPlants() {
        log.info("Controller: GET /api/plants : findAllPlants");
        List<Plant> plants = plantService.findAllPlants();
        
        return ResponseEntity.ok(plants);
    };

    @GetMapping("/plants/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Long id) {
        log.info("Controller: GET /api/plants/{id} : getPlantById");
        Optional<Plant> plantFound = plantService.findPlantById(id);

        return plantFound.isPresent() 
                ? ResponseEntity.ok(plantFound.get()) 
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/plants") 
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant) {
        log.info("Controller: POST /api/plants : createPlant");

        Optional<Plant> plantFound = plantService.savePlant(plant);

        return plantFound.isPresent() 
                ? ResponseEntity.status(HttpStatus.CREATED).body(plantFound.get()) 
                : ResponseEntity.badRequest().build();
    }

    @PutMapping("/plants/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id, @RequestBody Plant plant) {
        log.info("Controller: PUT /api/plants/{id} : updatePlant");

        Optional<Plant> plantUpdated = plantService.updatePlant(id,plant);

        return plantUpdated.isPresent() 
            ? ResponseEntity.ok(plantUpdated.get()) 
            : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/plants/{id}")
    public ResponseEntity<String> deletePlant(@PathVariable Long id) {
    log.info("Controller: DELETE /api/plants/{}", id);

    boolean plantDeleted = plantService.deletePlant(id);

    return plantDeleted == true
        ? ResponseEntity.ok("Plant deleted successfully") 
        : ResponseEntity.badRequest().build();
    }
}

