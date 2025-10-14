package com.minsait.comunidad.services;

import com.minsait.comunidad.domain.Colaborador;
import com.minsait.comunidad.dto.ColaboradorDto;

import java.util.List;
import java.util.Optional;

public interface ColaboradorServices {

    List<ColaboradorDto> findAllColaborador();
    ColaboradorDto updateColaborador(ColaboradorDto colaboradorReq , Colaborador colaboradorDto);
    ColaboradorDto saveColaborador(ColaboradorDto colaboradorDto);
    Optional<Colaborador> findByCodigo(String codigo);
    void deleteColaborador(String codigo);


}
