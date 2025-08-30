package com.example.controller;

import com.example.domain.Hotel;
import com.example.service.ShowHotelListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * トップページ用のコントローラ.
 */
@Controller
@RequestMapping("/")
public class ToppageController {

    @Autowired
    private ShowHotelListService showHotelListService;

    @GetMapping("/top")
    public String toToppage(Model model) {
        List<Hotel> hotelList = showHotelListService.searchAll();
        model.addAttribute("hotelList", hotelList);
        return "top";
    }
}
