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
 * ホテル一覧画面用のコントローラ.
 */
@Controller
@RequestMapping("/")
public class ShowHotelListController {

    @Autowired
    private ShowHotelListService showHotelListService;

    @GetMapping("/showHotelList")
    public String showHotelList(Model model) {
        List<Hotel> hotelList = showHotelListService.searchAll();
        model.addAttribute("hotelList", hotelList);
        return "hotel_list";
    }
}
