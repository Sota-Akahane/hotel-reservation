package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ホテル一覧表示用のサービス.
 */
@Service
@Transactional
public class ShowHotelListService {

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * ホテル一覧を取得します.
     *
     * @return ホテル一覧
     */
    public List<Hotel> searchAll() {
        return hotelRepository.findAll();
    }
}
