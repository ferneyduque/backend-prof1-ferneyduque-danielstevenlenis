package com.umanizales.cancha_inteligente.application;

import com.umanizales.cancha_inteligente.domain.ReservationDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationImpl implements ReservationAble{

    @Autowired
    @Qualifier("PostgresReservationRepository")
    private ReservationAble reservationPersistence;

    @Override
    public ReservationDTO save(ReservationDTO reservationDTO) {
        return reservationPersistence.save(reservationDTO);
    }

    @Override
    public ReservationDTO update(ReservationDTO reservationDTO) {
        return reservationPersistence.update(reservationDTO);
    }

    @Override
    public boolean delete(String idRes) throws CanchaInteligenteException {
        return reservationPersistence.delete(idRes);
    }

    @Override
    public List<ReservationDTO> list() {
        return reservationPersistence.list();
    }
}
