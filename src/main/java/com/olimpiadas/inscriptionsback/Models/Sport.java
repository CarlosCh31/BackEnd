package com.olimpiadas.inscriptionsback.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "sport")
@PrimaryKeyJoinColumn(name = "id")
public class Sport extends Activity {

    @Column(nullable = false)
    private String difficulty;

    @Column(name = "needs_special_equipment", nullable = false)
    private Boolean needs_special_equipment;

    @Column(name = "specifications")
    private String specifications;

    @Column(name = "level")
    private String level;

    public Sport() {
    }

    public Sport(String type, String name, String description, LocalDate date, LocalTime time, String duration, String modality, String location, Integer maxParticipants, Integer minimumAge, Integer maximumAge, Administrator administrator, String state,
                 String difficulty, Boolean needs_special_equipment, String specifications, String level) {
        super(type, name, description, date, time, duration, modality, location, maxParticipants, minimumAge, maximumAge, administrator, state);
        this.difficulty = difficulty;
        this.needs_special_equipment = needs_special_equipment;
        this.specifications = specifications;
        this.level = level;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Boolean getNeeds_special_equipment() {
        return needs_special_equipment;
    }

    public void setNeeds_special_equipment(Boolean needsSpecialEquipment) {
        this.needs_special_equipment = needsSpecialEquipment;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
