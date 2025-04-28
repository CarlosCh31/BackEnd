package com.olimpiadas.inscriptionsback.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "volunteer")
@PrimaryKeyJoinColumn(name = "id")
public class Volunteer extends Person {

    @Column(name = "sport_experience")
    private String sportExperience;


    public Volunteer() {
    }

    public Volunteer(String id, String name, Date birthdate, String email, String phone_number, String citizenship, String tipo, Region region, Province province, Canton canton, String sportExperience) {
        super(id, name, birthdate, email, phone_number, citizenship, tipo, region, province, canton);
        this.sportExperience = sportExperience;
    }

    public Volunteer(String sportExperience) {
        this.sportExperience = sportExperience;
    }

    public String getSportExperience() {
        return sportExperience;
    }

    public void setSportExperience(String sportExperience) {
        this.sportExperience = sportExperience;
    }
}
