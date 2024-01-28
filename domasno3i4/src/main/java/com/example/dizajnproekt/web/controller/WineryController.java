package com.example.dizajnproekt.web.controller;

import com.example.dizajnproekt.model.Winery;
import com.example.dizajnproekt.service.impl.WineryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/mww-wineries")
public class WineryController {
    private final WineryServiceImpl wineryService;
    @GetMapping("/home")
    public String getWineryPage(@RequestParam (required = false) String name,@RequestParam(required = false) String city ,Model model){
        List<Winery> wineries;
        if (name == null && city == null){
            wineries = wineryService.findAll();

        }
        else{
            wineries = wineryService.filter(name,city);
        }

        model.addAttribute("wineries",wineries);
        return "mww-wineries";
    }

    @GetMapping("/contact")
    public String getContacts(){

        return "message-form";
    }
    @GetMapping("/favorites")
    public String getFavorites(Model model){
        model.addAttribute("fav",this.wineryService.getFavorites());
        return "all-wineries";
    }

    @PostMapping("/info/{id}/favorites")
    public String addFavorites(@PathVariable Long id){
        wineryService.addToFavorites(id);
        return "redirect:/mww-wineries/favorites";
    }

    @GetMapping("/info/{id}")
    public String getInfo (@PathVariable Long id, Model model){
        Winery winery = wineryService.findById(id);
        model.addAttribute("winery", winery);
        return "winery-info";
    }

    @PostMapping("/info/{id}/rate")
    public String rate(@PathVariable Long id){
       this.wineryService.like(id);
        return "redirect:/mww-wineries/info/{id}";
    }
    @PostMapping ("/home/{id}/delete")
    public String delete(@PathVariable Long id){
        this.wineryService.delete(id);
        return "redirect:/mww-wineries/home";
    }

}
