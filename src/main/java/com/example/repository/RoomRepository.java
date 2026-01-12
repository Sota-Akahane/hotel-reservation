package com.example.repository;

import com.example.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roomsテーブルを操作するリポジトリ.
 */
@Repository
public class RoomRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Room> ROOM_ROW_MAPPER
            = (rs, i) -> {
        Room room = new Room();
        room.setId(rs.getInt("id"));
        room.setHotelId(rs.getInt("hotel_id"));
        room.setName(rs.getString("name"));
        room.setCapacity(rs.getInt("capacity"));
        room.setPrice(rs.getInt("price"));
        room.setDescription(rs.getString("description"));
        return room;
    };

    /**
     * ホテルに存在する部屋の一覧を取得する.
     *
     * @param hotelId ホテルID
     * @return 部屋一覧
     */
    public List<Room> findByHotelId(Integer hotelId) {
        String sql =
                """
                SELECT id,hotel_id,name,capacity,price,description FROM rooms
                 WHERE hotel_id=:hotelId
                """;

        SqlParameterSource param = new MapSqlParameterSource().addValue("hotelId", hotelId);

        return template.query(sql, param, ROOM_ROW_MAPPER);
    }
}
