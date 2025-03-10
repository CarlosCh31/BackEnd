package com.olimpiadas.inscriptionsback.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birthdate;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "citizenship")
    private String citizenship;



    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "province_id", nullable = false)
    private Province province_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "canton_id", nullable = false)
    private Canton canton_id;


    public Person() {
    }

    public Person(String id, String name, Date birthdate, String email, String phone_number, String citizenship, String tipo, Region region, Province province, Canton canton) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.phone_number = phone_number;
        this.citizenship = citizenship;
        this.region_id = region;
        this.province_id = province;
        this.canton_id = canton;
        this.tipo = tipo;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


    public Region getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Region region_id) {
        this.region_id = region_id;
    }

    public Province getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Province province) {
        this.province_id = province;
    }

    public Canton getCanton_id() {
        return canton_id;
    }

    public void setCanton_id(Canton canton) {
        this.canton_id = canton;
    }
    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
