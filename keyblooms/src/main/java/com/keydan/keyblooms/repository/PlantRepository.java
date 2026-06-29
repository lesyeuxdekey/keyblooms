package com.keydan.keyblooms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keydan.keyblooms.model.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    Optional<Plant> findByNameIgnoreCase(String name);
}
