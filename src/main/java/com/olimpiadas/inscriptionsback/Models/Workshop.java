package com.olimpiadas.inscriptionsback.Models;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "workshop")
@PrimaryKeyJoinColumn(name = "id")
public class Workshop extends Activity {

    @Column(length = 255)
    private String objectives;

    @Column(name = "target_audience", length = 255)
    private String target_audience;

    @Column(name = "needs_material")
    private Boolean needs_material;

    @Column(length = 255)
    private String specifications;

    public Workshop(String objectives, String target_audience, Boolean needs_material, String specifications) {
        this.objectives = objectives;
        this.target_audience = target_audience;
        this.needs_material = needs_material;
        this.specifications = specifications;
    }

    public Workshop(Long id, String objectives, String target_audience, Boolean needs_material, String specifications) {
        super.setId(id); // Heredado de Activity
        this.objectives = objectives;
        this.target_audience = target_audience;
        this.needs_material = needs_material;
        this.specifications = specifications;
    }
}

