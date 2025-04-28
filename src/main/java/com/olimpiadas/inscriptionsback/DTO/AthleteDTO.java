package com.olimpiadas.inscriptionsback.DTO;

import com.olimpiadas.inscriptionsback.Models.Athlete;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class AthleteDTO {
    private String name;
    private int age;
    private Date birthDate;
    private String phoneNumber;
    private String residence;
    private String disability_type;

    public AthleteDTO(Athlete athlete) {
        this.name = athlete.getName();
        this.birthDate = athlete.getBirthdate();
        this.age = calculateAge();
        this.phoneNumber = athlete.getPhone_number();
        this.residence = athlete.getCanton_id().toString();
        this.disability_type = athlete.getDisability_type();
    }

    public int calculateAge() {
        // Convert Date to LocalDate
        LocalDate birthLocalDate = new java.sql.Date(this.birthDate.getTime()).toLocalDate();
        LocalDate currentDate = LocalDate.now();

        // Calculate the period between the birthdate and the current date
        Period period = Period.between(birthLocalDate, currentDate);

        // Return the age in years
        return period.getYears();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getDisability_type() {
        return disability_type;
    }

    public void setDisability_type(String disability_type) {
        this.disability_type = disability_type;
    }
}
