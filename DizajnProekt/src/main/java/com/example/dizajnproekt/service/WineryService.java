package com.example.dizajnproekt.service;

import com.example.dizajnproekt.model.Winery;

import java.util.List;
import java.util.Optional;

public interface WineryService {

     List<Winery> findAll ();

   List<Winery> findByName(String name);
   Winery findById(Long id);
     List<Winery> findWineriesByCity(String city);

     Winery like(Long id);
    Winery delete(Long id);

    List<Winery> addToFavorites(Long id);

    Winery create(String name,String link, String location, String city, String phone, String wp, Double rating, Integer likes);
}