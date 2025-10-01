package com.minsait.comunidad.services;

import java.util.List;
import java.util.Optional;

import com.minsait.comunidad.domain.Colaborador;
import com.minsait.comunidad.dto.ColaboradorDto;

public interface ColaboradorServices {

    List<ColaboradorDto> findAllColaborador();
    ColaboradorDto updateColaborador(ColaboradorDto colaboradorReq , Colaborador colaboradorDto);
    ColaboradorDto saveColaborador(ColaboradorDto colaboradorDto);
   Optional<Colaborador> findByCodigo(String codigo);

/*

    Optional<ColaboradorDto> findBySolicitante(String solicitante);
    
    ColaboradorDto update(ColaboradorDto ticket , ColaboradorDto elemntoTicket);
    List<ColaboradorDto> getTicketToNow();
*/
}
