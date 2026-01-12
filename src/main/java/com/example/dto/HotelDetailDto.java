package com.example.dto;

import com.example.domain.Hotel;
import com.example.domain.Room;

import java.util.List;

/**
 * ホテル詳細画面で使用するDTO.
 * ホテルと部屋の情報を保持する。
 */
public class HotelDetailDto {
    private Hotel hotel;
    private List<Room> rooms;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
