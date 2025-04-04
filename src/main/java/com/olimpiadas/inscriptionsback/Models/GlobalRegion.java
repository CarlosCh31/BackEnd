package com.olimpiadas.inscriptionsback.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "global_regions")
public class GlobalRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

