package com.example.controller;

import com.example.domain.Hotel;
import com.example.service.ShowHotelDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ホテル詳細画面用のコントローラ.
 */
@Controller
@RequestMapping("/")
public class ShowHotelDetailController {

    @Autowired
    private ShowHotelDetailService hotelDetailService;

    @GetMapping("/showHotelDetail")
    public String showHotelDetail(Integer hotelId, Model model) {
        Hotel hotel = hotelDetailService.showHotelDetail(hotelId);
        model.addAttribute("hotel", hotel);
        return "detail";
    }
}
