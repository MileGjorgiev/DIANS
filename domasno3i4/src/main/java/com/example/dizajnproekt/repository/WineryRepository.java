package com.example.dizajnproekt.repository;


import com.example.dizajnproekt.model.Winery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.synth.Region;
import java.util.List;
import java.util.Optional;

@Repository
public interface WineryRepository extends JpaRepository<Winery,Long> {
    List<Winery> findByName(String name);
    List<Winery> findByCity(String city);

    List<Winery> findByNameAndCity(String name, String city);
}