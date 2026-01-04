package com.example.controller;

import com.example.dto.ReservationDto;
import com.example.form.ReservationForm;
import com.example.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    /**
     * 予約画面を表示する.
     *
     * @return 予約画面
     */
    @GetMapping("/toReservation")
    public String toReservation(Integer hotelId, Model model, ReservationForm reservationForm) {
        ReservationDto reservationDto = reservationService.getReservationDto(hotelId);
        model.addAttribute("hotel", reservationDto);
        return "reservation";
    }

    @PostMapping("/reserve")
    public String reserve(ReservationForm reservationForm) {
        reservationService.Reserve(reservationForm);
        return "confirm";
    }
}
