package com.example.controller;

import com.example.form.RegisterUserForm;
import com.example.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ユーザ登録処理を制御するコントローラ.
 */
@Controller
@RequestMapping("/")
public class RegisterUserController {

    @Autowired
    private RegisterUserService registerUserService;

    /**
     * ユーザ登録画面を表示する.
     *
     * @return ユーザ登録画面
     */
    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    /**
     * ユーザ登録をする.
     *
     * @param form ユーザ登録用フォーム
     * @return ホテル一覧画面
     */
    @PostMapping("/register")
    public String register(RegisterUserForm form) {
        registerUserService.registerUser(form);

        return "hotel_list";
    }
}
