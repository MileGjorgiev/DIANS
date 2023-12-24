package com.example.dizajnproekt.service;

import com.example.dizajnproekt.model.Winery;

import java.util.List;
import java.util.Optional;

public interface WineryService {

    public List<Winery> findAll ();

    public List<Winery> findByName(String name);
    public Optional<Winery> findById(Long id);
}