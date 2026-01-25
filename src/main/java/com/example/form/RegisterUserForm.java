package com.example.form;

/**
 * ユーザ登録時に使用するフォーム.
 */
public class RegisterUserForm {
    /** 名前 */
    private String name;
    /** メールアドレス */
    private String email;
    /** パスワード */
    private String password;
    /** 確認用パスワード */
    private String confirmPassword;
    /** 電話番号 */
    private String telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
