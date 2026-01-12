package com.example.controller;

import com.example.domain.Hotel;
import com.example.dto.HotelDetailDto;
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
        HotelDetailDto hotelDetail = hotelDetailService.showHotelDetail(hotelId);
        model.addAttribute("hotel", hotelDetail.getHotel());
        model.addAttribute("rooms", hotelDetail.getRooms());
        return "detail";
    }
}
