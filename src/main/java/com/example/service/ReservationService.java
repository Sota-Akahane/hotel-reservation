package com.example.service;

import com.example.domain.Hotel;
import com.example.domain.Reservation;
import com.example.dto.ReservationDto;
import com.example.form.ReservationForm;
import com.example.repository.HotelRepository;
import com.example.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ReservationRepository reservationRepository;

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

    public void reserve(ReservationForm reservationForm, Integer userId) {
        Reservation reservation = new Reservation();
        reservation.setUserId(userId);
        reservation.setRoomId(reservationForm.getRoomId());
        reservation.setCheckinDate(reservationForm.getCheckinDate());
        reservation.setCheckoutDate(reservationForm.getCheckoutDate());
        reservation.setGuestCount(reservationForm.getGuestCount());
        reservation.setPlanId(reservationForm.getPlanId());
        reservation.setPaymentMethod(reservationForm.getPaymentMethod());
        reservation.setTotalPrice(reservationForm.getTotalPrice());
        reservation.setStatus(reservationForm.getStatus());
        reservationRepository.insert(reservation);
    }
}
