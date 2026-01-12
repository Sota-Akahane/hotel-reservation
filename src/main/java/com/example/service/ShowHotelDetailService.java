package com.example.service;

import com.example.domain.Hotel;
import com.example.domain.Room;
import com.example.dto.HotelDetailDto;
import com.example.repository.HotelRepository;
import com.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ホテル詳細表示用のサービス.
 */
@Service
@Transactional
public class ShowHotelDetailService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    /**
     * ホテル詳細情報を取得する.
     * ホテルと部屋の両方の情報を取得する。
     *
     * @param id ホテルID
     * @return ホテルと部屋の情報
     */
    public HotelDetailDto showHotelDetail(Integer id) {
        Hotel hotel =  hotelRepository.findById(id);
        List<Room> rooms = roomRepository.findByHotelId(id);
        HotelDetailDto hotelDetail = new HotelDetailDto();
        hotelDetail.setHotel(hotel);
        hotelDetail.setRooms(rooms);
        return hotelDetail;
    }
}
