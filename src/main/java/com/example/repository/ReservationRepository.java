package com.example.repository;

import com.example.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Reservation> RESERVATION_ROW_MAPPER
            = (rs, i) -> {
        Reservation reservation = new Reservation();
        reservation.setId(rs.getInt("id"));
        reservation.setUserId(rs.getInt("user_id"));
        reservation.setRoomId(rs.getInt("room_id"));
        reservation.setCheckinDate(rs.getDate("checkin_date").toLocalDate());
        reservation.setCheckoutDate(rs.getDate("checkout_date").toLocalDate());
        reservation.setGuestCount(rs.getInt("guest_count"));
        reservation.setPlanId(rs.getInt("plan_id"));
        reservation.setPaymentMethod(rs.getInt("payment_method"));
        reservation.setTotalPrice(rs.getInt("total_price"));
        reservation.setStatus(rs.getInt("status"));
        reservation.setCreatedAt(rs.getDate("created_at"));
        return reservation;
    };

    public void insert(Reservation reservation) {
        String sql =
                """
                INSERT INTO reservations(
                user_id, room_id, checkin_date, checkout_date, guest_count,
                plan_id, payment_method, total_price, status)
                VALUES (
                :userId, :roomId, :checkinDate, :checkoutDate, :guestCount,
                :planId, :paymentMethod, :totalPrice, :status)
                """;

        SqlParameterSource param
                = new MapSqlParameterSource()
                .addValue("userId", 1)
                .addValue("roomId", 1)
                .addValue("checkinDate", reservation.getCheckinDate())
                .addValue("checkoutDate", reservation.getCheckoutDate())
                .addValue("guestCount", reservation.getGuestCount())
                .addValue("planId", reservation.getPlanId())
                .addValue("paymentMethod", "credit")
                .addValue("totalPrice", 5000)
                .addValue("status", "booked");

        template.update(sql, param);
    }
}
