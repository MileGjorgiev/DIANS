package com.example.dizajnproekt.model;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity

public class Winery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String link;
    private String location;
    private String city;
    private String phone;
    private String wp;
    private Double rating;
    private Integer likes;




    public Winery(String name, String link, String location, String city, String phone, String wp, Double rating, Integer likes) {
        this.name = name;
        this.link = link;
        this.location = location;
        this.city = city;
        this.phone = phone;
        this.wp = wp;
        this.rating = rating;
        this.likes = likes;

    }


    public Winery() {
    }
}