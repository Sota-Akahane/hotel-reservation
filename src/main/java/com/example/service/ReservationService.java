package com.example.service;

import com.example.domain.Hotel;
import com.example.dto.ReservationDto;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private HotelRepository hotelRepository;

    public ReservationDto getReservationDto(Integer id) {
        Hotel hotel = hotelRepository.findById(id);

        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(id);
        reservationDto.setName(hotel.getName());
        reservationDto.setImagePath(hotel.getImagePath());
        reservationDto.setZipcode(hotel.getZipcode());
        reservationDto.setAddress(hotel.getAddress());
        reservationDto.setTelephone(hotel.getTelephone());

        return reservationDto;
    }
}
