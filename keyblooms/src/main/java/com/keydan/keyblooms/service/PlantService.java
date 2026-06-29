package com.keydan.keyblooms.service;

import java.util.List;
import java.util.Optional;

import com.keydan.keyblooms.model.Plant;

public interface PlantService {

    List<Plant> findAllPlants();
    Optional<Plant> findPlantById(Long id);
    Optional<Plant> savePlant(Plant plant);
    Optional<Plant> updatePlant(Long id, Plant plantDetails);
    boolean deletePlant(Long id);
}
