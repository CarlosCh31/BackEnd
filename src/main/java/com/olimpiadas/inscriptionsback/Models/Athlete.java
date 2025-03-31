package com.olimpiadas.inscriptionsback.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "athlete")
@PrimaryKeyJoinColumn(name = "id")
public class Athlete extends Person {

    // Otros atributos específicos de Athlete
    @Column(name = "laterality")
    @Size(max = 10, message = "Laterality cannot exceed 10 characters") // Validación de tamaño
    private String laterality;

    @Column(name = "disability_type")
    @Size(max = 50, message = "Disability type cannot exceed 50 characters") // Validación de tamaño
    private String disability_type;

    // Nuevo atributo: peso del atleta
    @Column(name = "weight")
    private Double weight;

    // Nuevo atributo: altura del atleta
    @Column(name = "height")
    private Double height;

    // Getters y setters para laterality
    public String getLaterality() {
        return laterality;
    }

    public void setLaterality(String laterality) {
        this.laterality = laterality;
    }

    // Getters y setters para disabilityType
    public String getDisability_type() {
        return disability_type;
    }

    public void setDisability_type(String disability_type) {
        this.disability_type = disability_type;
    }

    // Getters y setters para weight
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    // Getters y setters para height
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}

