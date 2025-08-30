package com.example.repository;

import com.example.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * hotelsテーブルを操作するリポジトリ.
 */
@Repository
public class HotelRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER
            = (rs, i) -> {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setName(rs.getString("name"));
        hotel.setDescription(rs.getString("description"));
        hotel.setImagePath(rs.getString("image_path"));
        hotel.setZipcode(rs.getString("zipcode"));
        hotel.setAddress(rs.getString("address"));
        hotel.setTelephone(rs.getString("telephone"));
        hotel.setRegionId(rs.getInt("region_id"));
        hotel.setDeleted(rs.getBoolean("deleted"));
        return hotel;
    };

    /**
     * 全件検索します.
     *
     * @return ホテル一覧
     */
    public List<Hotel> findAll() {
        String sql =
                """
                SELECT id,name,description,image_path,zipcode,address,telephone,region_id,deleted
                 FROM hotels ORDER BY id
                """;

        return template.query(sql, HOTEL_ROW_MAPPER);
    }
}
