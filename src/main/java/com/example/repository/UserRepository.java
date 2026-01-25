package com.example.repository;

import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 * usersテーブルを操作するリポジトリ.
 */
@Repository
public class UserRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<User> USER_ROW_MAPPER
            = (rs, i) -> {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setTelephone(rs.getString("telephone"));
        return user;
    };

    /**
     * ユーザを登録する.
     *
     * @param user 登録ユーザ
     */
    public void insert(User user) {
        String sql =
                """
                INSERT INTO users(name,email,password,telephone) VALUES
                 (:name,:email,:password,:telephone)
                """;

        SqlParameterSource param
                = new MapSqlParameterSource()
                .addValue("name", user.getName())
                .addValue("email", user.getEmail())
                .addValue("password", user.getPassword())
                .addValue("telephone", user.getTelephone());

        template.update(sql, param);
    }

    /**
     * メールアドレスとパスワードでユーザを検索する.
     *
     * @param email メールアドレス
     * @param password パスワード
     * @return ユーザ
     */
    public User findByEmailAndPassword(String email, String password) {
        String sql =
                """
                SELECT id,name,email,password,telephone FROM users
                 WHERE email=:email AND password=:password
                """;

        SqlParameterSource param
                = new MapSqlParameterSource()
                .addValue("email", email)
                .addValue("password", password);

        return template.queryForObject(sql, param, USER_ROW_MAPPER);
    }
}
