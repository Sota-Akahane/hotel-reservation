package com.example.service;

import com.example.domain.User;
import com.example.form.RegisterUserForm;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ユーザ登録処理を実行するサービス.
 */
@Service
@Transactional
public class RegisterUserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザを登録する.
     *
     * @param form 登録ユーザ情報を保持するフォーム
     */
    public void registerUser(RegisterUserForm form) {
        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setTelephone(form.getTelephone());

        userRepository.insert(user);
    }
}
