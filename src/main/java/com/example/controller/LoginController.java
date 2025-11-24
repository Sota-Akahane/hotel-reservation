package com.example.controller;

import com.example.domain.User;
import com.example.form.LoginForm;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ログイン処理用のコントローラ.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * ログイン画面を表示する.
     *
     * @param loginForm フォーム
     * @return ログイン画面
     */
    @GetMapping("/toLogin")
    public String toLogin(LoginForm loginForm, Model model) {
        return "login";
    }

    /**
     * ログインする.
     *
     * @param loginForm フォーム
     * @return ログイン成功：トップページ、ログイン失敗：ログイン画面
     */
    @PostMapping("/login")
    public String login(@Validated LoginForm loginForm,
                        BindingResult result,
                        Model model) {
        if (result.hasErrors()) {
            return "login";
        }

        User user = loginService.login(loginForm);
        if(user == null) {
            return "login";
        }

        return "top";
    }
}
