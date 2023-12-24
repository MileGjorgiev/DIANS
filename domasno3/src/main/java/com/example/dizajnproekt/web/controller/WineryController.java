package com.example.dizajnproekt.web.controller;

import com.example.dizajnproekt.model.Winery;
import com.example.dizajnproekt.service.impl.WineryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/mww-wineries")
public class WineryController {
    private final WineryServiceImpl wineryService;
    @GetMapping
    public String getWineryPage(){
        return "mww-wineries";
    }

    @GetMapping("/contact")
    public String getContacts(){

        return "message-form";
    }

    @GetMapping("/all")
    public String getAllWineries(Model model){

        List<Winery> wineries=wineryService.findAll();
        model.addAttribute("wineries", wineries);
        return "all-wineries";
    }

    @GetMapping("/info")
    public String getInfo (Model model){
        List<Winery> winery = wineryService.findAll();
        model.addAttribute("winery", winery);
        return "winery-info";
    }

    @PostMapping("/search")
    public String getBySearch(@RequestParam String name, Model model){
        List<Winery> winery = wineryService.findByName(name);
        model.addAttribute("winery", winery);
        return "all-wineries";
    }


}
