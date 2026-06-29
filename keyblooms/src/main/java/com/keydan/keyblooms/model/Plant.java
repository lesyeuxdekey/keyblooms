package com.keydan.keyblooms.model;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plants")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @Enumerated(EnumType.STRING)
    private PlantCategory category; 

    private String description;
    
    private Integer wateringInterval; // In days
    
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private LightRequirement light;
    
    private String imgLink; 
}