package com.atelier.tenisu.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Country {

    private String picture;
    private String code;

    public Country() {

    }
    
    public Country(String code) {
        this.code = code;
    }
    
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture){
        this.picture = picture;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

}
