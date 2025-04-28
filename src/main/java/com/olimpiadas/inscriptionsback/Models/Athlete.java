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
    @Size(max = 50, message = "Laterality cannot exceed 10 characters") // Validación de tamaño
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

    @Column(name = "sub_program")
    private String subProgram;

    @Column(name = "state")
    @Size(max = 50, message = "State type cannot exceed 50 characters")
    private String state;

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

    public String getSubProgram() {
        return subProgram;
    }

    public void setSubProgram(String subProgram) {
        this.subProgram = subProgram;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "laterality='" + laterality + '\'' +
                ", disability_type='" + disability_type + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", subProgram='" + subProgram + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

