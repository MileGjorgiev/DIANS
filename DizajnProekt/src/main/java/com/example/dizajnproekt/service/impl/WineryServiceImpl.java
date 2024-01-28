package com.example.dizajnproekt.service.impl;

import com.example.dizajnproekt.model.Winery;
import com.example.dizajnproekt.model.exceptions.InvalidWineryIdException;
import com.example.dizajnproekt.model.exceptions.InvalidWineryNameException;
import com.example.dizajnproekt.repository.WineryRepository;
import com.example.dizajnproekt.service.WineryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WineryServiceImpl implements WineryService {

    private final WineryRepository wineryRepository;
    private List<Winery> favorites = new ArrayList<>();
    @Override
    public List<Winery> findAll() {
        return wineryRepository.findAll();
    }

    @Override
    public List<Winery> findByName(String name) {
        return this.wineryRepository.findByName(name);
    }

    @Override
    public Winery findById(Long id) {
        return wineryRepository.findById(id).orElseThrow(InvalidWineryIdException::new);
    }

    @Override
    public List<Winery> findWineriesByCity(String city) {
        return this.wineryRepository.findByCity(city);
    }

   @Override
    public Winery like(Long id) {
        Winery winery = wineryRepository.findById(id).orElseThrow(InvalidWineryIdException::new);

        winery.setLikes(winery.getLikes() + 1);

      return wineryRepository.save(winery);
    }

    @Override
    public List<Winery> addToFavorites(Long id) {
        Winery winery = wineryRepository.findById(id).orElseThrow(InvalidWineryIdException::new);


        if (!favorites.contains(winery)) {
            favorites.add(winery);
        }


        return favorites;
    }

    @Override
    public Winery create(String name, String link, String location, String city, String phone, String wp, Double rating, Integer likes) {
        Winery winery = new Winery(name,link,location,city,phone,wp,rating,likes);
        return wineryRepository.save(winery);
    }

    public List<Winery> getFavorites() {

        return favorites;
    }

    public Winery delete(Long id){
        Winery winery=findById(id);
        wineryRepository.delete(winery);
        return winery;
    }
    public List<Winery> filter(String name,String city){
        if (!name.isEmpty() && !city.isEmpty()) {
            return wineryRepository.findByNameAndCity(name, city);
        }
        else if (!name.isEmpty()){
            return wineryRepository.findByName(name);
        }
       else if (!city.isEmpty()){
            return wineryRepository.findByCity(city);
        }
        else {return wineryRepository.findAll();}
    }
}
