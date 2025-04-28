package com.olimpiadas.inscriptionsback.DTO;

import com.olimpiadas.inscriptionsback.Models.Activity;

import java.time.LocalDate;
import java.time.LocalTime;

public class ActivityDTO {
    private Long id;
    private String name;
    private String type;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private String duration;
    private String modality;
    private String location;
    private Integer maxParticipants;
    private Integer minimumAge;
    private Integer maximumAge;
    private String state;
    private String administratorEmail;

    // Constructor que mapea desde la entidad
    public ActivityDTO(Activity activity) {
        this.id = activity.getId();
        this.name = activity.getName();
        this.type = activity.getType();
        this.description = activity.getDescription();
        this.date = activity.getDate();
        this.time = activity.getTime();
        this.duration = activity.getDuration();
        this.modality = activity.getModality();
        this.location = activity.getLocation();
        this.maxParticipants = activity.getMaxParticipants();
        this.minimumAge = activity.getMinimumAge();
        this.maximumAge = activity.getMaximumAge();
        this.state = activity.getState();
        this.administratorEmail = activity.getAdministrator().getEmail();
    }

    public ActivityDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Integer getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(Integer maximumAge) {
        this.maximumAge = maximumAge;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAdministratorEmail() {
        return administratorEmail;
    }

    public void setAdministratorEmail(String administratorEmail) {
        this.administratorEmail = administratorEmail;
    }
}

