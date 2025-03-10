package com.olimpiadas.inscriptionsback.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "sport")
@PrimaryKeyJoinColumn(name = "activity_id")
public class Sport extends Activity {

    @Column(nullable = false)
    private String difficulty;

    @Column(name = "needs_special_equipment", nullable = false)
    private Boolean needsSpecialEquipment;

    @Column(name = "specifications")
    private String specifications;

    @Column(name = "level")
    private String level;

    public Sport() {
    }

    public Sport(String type, String name, String description, LocalDate date, LocalTime time, String duration, String modality, String location, Integer maxParticipants, Integer minimumAge, Integer maximumAge, Administrator administrator, String state,
                 String difficulty, Boolean needsSpecialEquipment, String specifications, String level) {
        super(type, name, description, date, time, duration, modality, location, maxParticipants, minimumAge, maximumAge, administrator, state);
        this.difficulty = difficulty;
        this.needsSpecialEquipment = needsSpecialEquipment;
        this.specifications = specifications;
        this.level = level;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Boolean getNeedsSpecialEquipment() {
        return needsSpecialEquipment;
    }

    public void setNeedsSpecialEquipment(Boolean needsSpecialEquipment) {
        this.needsSpecialEquipment = needsSpecialEquipment;
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
