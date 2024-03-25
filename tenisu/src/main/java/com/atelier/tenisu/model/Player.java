package com.atelier.tenisu.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;
    private String firstname;
    private String lastname;
    private String shortname;
    private String sex;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "picture", column = @Column(name = "country_picture")),
    })
    private Country country;
    private String picture;
    @Embedded
    private Data data;

    public Player(){

    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
    
}
