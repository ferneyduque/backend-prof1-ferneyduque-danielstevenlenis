package com.umanizales.cancha_inteligente.infrastructure.adapters;

import com.umanizales.cancha_inteligente.application.ReservationAble;
import com.umanizales.cancha_inteligente.domain.ClientDTO;
import com.umanizales.cancha_inteligente.domain.ReservationDTO;
import com.umanizales.cancha_inteligente.exceptions.CanchaInteligenteException;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ClientEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ReservationEntity;
import com.umanizales.cancha_inteligente.infrastructure.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Qualifier("PostgresReservationRepository")
@Repository("ReservationPersistence")
public class PostgresReservationRepository implements ReservationAble {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ReservationDTO save(ReservationDTO reservationDTO) {

        return reservationRepository.save(new ReservationEntity(reservationDTO)).toreservationDTO();
    }

    @Override
    public ReservationDTO update(ReservationDTO reservationDTO) {
        return null;
    }

    @Override
    public boolean delete(String idRes) throws CanchaInteligenteException {

        if (reservationRepository.existsById(idRes)){

            reservationRepository.deleteById(idRes);
            return true;
        }
        else {
            throw new CanchaInteligenteException("El codigo a borrar no existe");
        }
    }

    @Override
    public List<ReservationDTO> list() {

        List<ReservationEntity> reservations= reservationRepository.findAll();
        List<ReservationDTO> reservationsDTO= new ArrayList<>();
        for(ReservationEntity reservation:reservations)
        {
            reservationsDTO.add(reservation.toreservationDTO());
        }

        return reservationsDTO;
    }
}
