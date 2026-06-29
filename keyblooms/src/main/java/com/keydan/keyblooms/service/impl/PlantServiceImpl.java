package com.keydan.keyblooms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keydan.keyblooms.model.Plant;
import com.keydan.keyblooms.repository.PlantRepository;
import com.keydan.keyblooms.service.PlantService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;


    @Override
    public List<Plant> findAllPlants() {
        log.info("\nService: findAllPlants");
        log.info("Fetching all plants from the database");

        List<Plant> plants = plantRepository.findAll();
        
        if (plants.isEmpty()) {
            log.warn("Inventory check: No plants found in the database."); 
        }
        
        return plants;    
    }

    @Override
    public Optional<Plant> findPlantById(Long id) {
        log.info("Service: findPlantById with ID: {}", id);

        if (!isIdValid(id)) {
            return Optional.empty();
        }

        return plantRepository.findById(id);
    }

    @Override
    public Optional<Plant> savePlant(Plant newPlant) {
        log.info("Service: savePlant");

        if (!isPlantDataValid(newPlant)) {
            return Optional.empty();
        }

        Optional<Plant> existingPlant = plantRepository.findByNameIgnoreCase(newPlant.getName());
        if (existingPlant.isPresent()) {
            log.warn("Validation failed: A plant named '{}' already exists.", newPlant.getName());
            return Optional.empty();
        }

        return Optional.of(plantRepository.save(newPlant));
}

    @Override
    public Optional<Plant> updatePlant(Long id, Plant plantDetails) {
        log.info("\nService: updatePlant");

        if (!isPlantDataValid(plantDetails)) {
            log.info("\nPlant can't be updated because some inputs are incorrect, please check.");
            return Optional.empty();
        }

        if(plantAlreadyExist(id, plantDetails)){
           log.info("\nPlant can't be updated because the new name you're trying to update already exists");
           return Optional.empty(); 
        }
        
        Optional<Plant> existingPlant = findPlantById(id);
        
        if (existingPlant.isPresent()) {
            log.info("\nPlant found in our inventory");
            Plant plantFound = existingPlant.get();
            
            plantFound.setName(plantDetails.getName());
            plantFound.setCategory(plantDetails.getCategory());       
            plantFound.setWateringInterval(plantDetails.getWateringInterval());
            plantFound.setDescription(plantDetails.getDescription());
            plantFound.setLight(plantDetails.getLight());
            plantFound.setQuantity(plantDetails.getQuantity());
            plantFound.setImgLink(plantDetails.getImgLink());

            plantRepository.save(plantFound);
            return Optional.of(plantFound);
        }

        log.info("\nPlant NOT found in our inventory");
        return Optional.empty();
    }

    @Override
    public boolean deletePlant(Long id) {
        log.info("Service: deletePlant with ID: {}", id);

        if (!isIdValid(id)) {
            log.warn("Delete aborted: Invalid ID input.");
            return false; 
        }

        Optional<Plant> plantOptional = plantRepository.findById(id);
        if (plantOptional.isPresent()) {
            plantRepository.delete(plantOptional.get());
            log.info("Plant with ID {} successfully deleted.", id);
            return true;
        } else {
            log.warn("Delete failed: Plant with ID {} not found.", id);
            return false;
        }
    }

    //Private methods

    private boolean isPlantDataValid(Plant plant) {
        log.info("\nService: isPlantDataValid");

        if (plant == null) {
            log.warn("Validation failed: The plant object is null.");
            return false;
        }

        if (plant.getName() == null || plant.getName().isBlank()) {
            log.info("\nPlant name is empty, please correct.");
            return false;
        }
        
        if(plant.getWateringInterval() == null || plant.getWateringInterval() <= 0) {
            log.info("\nPlant watering interval must be a number from > 0");
            return false;
        }
        
        if(plant.getQuantity() == null || plant.getQuantity() <= 0) {
            log.info("\nPlant quantity interval must be a number from > 0");
            return false;
        }
        
        return true;
    }

    private boolean isIdValid(Long id) {
    log.info("\nService:  isIdValid");

    if (id == null) {
        log.warn("Validation failed: The provided ID is null.");
        return false;
    }
    if (id <= 0L) {
        log.warn("Validation failed: ID {} is invalid. It must be greater than 0.", id);
        return false;
    }
    return true;
    }

    private boolean plantAlreadyExist(Long id, Plant plantDetails) {
        log.info("\nService: plantAlreadyExist");
        
        Optional<Plant> plantWithSameName = plantRepository.findByNameIgnoreCase(plantDetails.getName());
        
        if (plantWithSameName.isPresent()) {
            long existingPlantId = plantWithSameName.get().getId();
            long currentEditingId = id;

            if (existingPlantId != currentEditingId) {
                log.warn("Validation failed: Cannot rename. The name '{}' is already taken by plant ID {}.", 
                        plantDetails.getName(), existingPlantId);
                return true; 
            }
        }
        return false;
    }
}
