package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ホテル詳細表示用のサービス.
 */
@Service
@Transactional
public class ShowHotelDetailService {

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * ホテル詳細情報を取得します.
     * 
     * @param id ホテルID
     * @return ホテル情報
     */
    public Hotel showHotelDetail(Integer id) {
        return hotelRepository.findById(id);
    }
}
