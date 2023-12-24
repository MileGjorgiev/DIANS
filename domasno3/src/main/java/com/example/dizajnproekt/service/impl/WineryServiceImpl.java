package com.example.dizajnproekt.service.impl;

import com.example.dizajnproekt.model.Winery;
import com.example.dizajnproekt.repository.WineryRepository;
import com.example.dizajnproekt.service.WineryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WineryServiceImpl implements WineryService {

    private final WineryRepository wineryRepository;
    @Override
    public List<Winery> findAll() {
        return wineryRepository.findAll();
    }

    @Override
    public List<Winery> findByName(String name) {
        return wineryRepository.findByName(name);
    }

    @Override
    public Optional<Winery> findById(Long id) {
        return wineryRepository.findById(id);
    }
}
