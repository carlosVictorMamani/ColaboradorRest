package com.minsait.comunidad.services;

import java.util.List;
import java.util.Optional;
import com.minsait.comunidad.domain.Colaborador;
import com.minsait.comunidad.domain.Curso;
import com.minsait.comunidad.dto.ColaboradorDto;
import com.minsait.comunidad.repository.ColaboradorRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;  
import com.minsait.comunidad.mapper.ColaboradorMapper;

@Service
public class ColaboradorServicesImpl implements ColaboradorServices {
    
    private ColaboradorRepository repository;
    private ColaboradorMapper mapper;

    public ColaboradorServicesImpl(ColaboradorRepository repository, ColaboradorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /*@Override
    @Transactional(readOnly = true)
    public Optional<Colaborador> findByCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }*/
    

    @Override
    @Transactional
    public ColaboradorDto updateColaborador(ColaboradorDto colaboradorReq , Colaborador colaborador) {

         colaborador.setNombre(colaboradorReq.getNombre());
         colaborador.setApellidoPaterno(colaboradorReq.getApellidoPaterno());
         colaborador.setApellidoMaterno(colaboradorReq.getApellidoMaterno());
         if (colaboradorReq.getCurso() != null) {
            String codigoCurso = colaboradorReq.getCurso().getCodigo();
            String nombreCurso = colaboradorReq.getCurso().getNombre();
            Curso curso = new Curso(codigoCurso, nombreCurso);
            colaborador.setCurso(curso);
         }
        Colaborador objColaborador = this.repository.save(colaborador);
        return mapper.toDto(objColaborador);             
    }

    @Override
    public ColaboradorDto saveColaborador(ColaboradorDto colaboradorDto) {
      Colaborador colaborador = this.repository.save(mapper.toEntity(colaboradorDto));
      return mapper.toDto(colaborador);
    }

    @Override
    public Optional<Colaborador> findByCodigo(String codigo) {
        return repository.findById(new ObjectId(codigo));
    }

    
    }

 

    //Final de Jornada los tickets asignados no han sido resueltos se pasa al estado ATRASADO
    /*@Override
    @Transactional(readOnly = true)
    public List<ColaboradorDto> updateStatusAll() {

        List<Colaborador> ticketsHoy = repository.findAll().stream()
            .filter(ticket -> ticket.getFechaCreacion() != null &&
                ticket.getFechaCreacion().toLocalDate().equals(java.time.LocalDate.now()))
            .toList();

         List<ColaboradorDto> ticketsHoyDto =   mapper.toListDto(ticketsHoy);

        return ticketsHoyDto.stream()
                 .filter(t -> t.getEstado() == Estado.ASIGNADO)
                .map(t -> {
                    t.setEstado(Estado.ATRASADO);
                    return mapper.toDto(repository.save(mapper.toEntity(t)));
                }).toList();
    }
        
    
    @Override
    @Transactional
    public ColaboradorDto generateTicket(ColaboradorDto ticket) {
        Colaborador newTicket = mapper.toEntity(ticket);
        newTicket.setCodigo(Utils.generateCodigo());
        newTicket.setEstado(Estado.NUEVO);
        newTicket.setUsuarioGenerador(ticket.getUsuarioGenerador()); 
        newTicket.setOrden(getNextOrdenForToday()); 
        newTicket.setFechaCreacion(java.time.LocalDateTime.now());
        return mapper.toDto(repository.save(newTicket));
    }
    
    private long getNextOrdenForToday() {
        long count = repository.findAll().stream()
            .filter(ticket -> ticket.getFechaCreacion() != null &&
            Utils.formatLocalDateTimeToDate(ticket.getFechaCreacion())
                .equals(Utils.formatLocalDateTimeToDate(java.time.LocalDateTime.now())))
            .count();
        return count +1 ;
    }

    @Override
    public List<ColaboradorDto> getTicketToNow() {
        List<Colaborador> ticketsHoy = repository.findAll().stream()
            .filter(ticket -> ticket.getFechaCreacion() != null &&
                ticket.getFechaCreacion().toLocalDate().equals(java.time.LocalDate.now()))
            .toList();
        return  mapper.toListDto(ticketsHoy);
    }

    @Override
    public Optional<ColaboradorDto> findBySolicitante(String solicitante) {
       return repository.findBySolicitante(solicitante).map(mapper::toDto);
    }*/

    
}
