package com.example.controller;

import com.example.domain.User;
import com.example.dto.ReservationDto;
import com.example.form.ReservationForm;
import com.example.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserve")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    /**
     * 予約画面を表示する.
     *
     * @return 予約画面
     */
    @GetMapping("")
    public String toReservation(Integer hotelId, Model model, ReservationForm reservationForm, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        ReservationDto reservationDto = reservationService.getReservationDto(hotelId);
        model.addAttribute("hotel", reservationDto);
        return "reservation";
    }

    /**
     * 予約確認画面に遷移する.
     *
     * @param model リクエストスコープ
     * @param reservationForm 予約情報を持つフォーム
     * @return 予約確認画面
     */
    @PostMapping("/confirm")
    public String confirm(Model model, ReservationForm reservationForm) {
        // TODO: 入力値チェックをする
        model.addAttribute("reservationForm", reservationForm);
        return "confirm";
    }

    /**
     * 予約を完了する.
     *
     * @param reservationForm 予約情報を持つフォーム
     * @param session セッションスコープ
     * @return 予約完了画面
     */
    @PostMapping("/complete")
    public String reserve(ReservationForm reservationForm, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        reservationService.Reserve(reservationForm, loginUser.getId());
        return "complete";
    }
}
