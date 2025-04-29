package com.olimpiadas.inscriptionsback.DTO;

public class ActivityResultsDTO {

    private String athlete;
    private Long activity;
    private String position;
    private String time;

    public ActivityResultsDTO() {
    }

    public ActivityResultsDTO(String athlete, Long activity, String position, String time) {
        this.athlete = athlete;
        this.activity = activity;
        this.position = position;
        this.time = time;
    }

    // Getters y Setters
    public String getAthlete() {
        return athlete;
    }

    public void setAthlete(String athlete) {
        this.athlete = athlete;
    }

    public Long getActivity() {
        return activity;
    }

    public void setActivity(Long activity) {
        this.activity = activity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
