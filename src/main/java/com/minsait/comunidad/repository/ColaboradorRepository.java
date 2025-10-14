package com.minsait.comunidad.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.minsait.comunidad.domain.Colaborador;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;

@Repository
public interface ColaboradorRepository extends MongoRepository<Colaborador, ObjectId> {

    Optional<Colaborador> findById(ObjectId id);

    /* prueba */
    /* Optional<Ticket> findBySolicitante(String solicitante);

    long countByFechaCreacion(Date fechaCreacion); */
}
