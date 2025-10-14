package com.minsait.comunidad.services;

import com.minsait.comunidad.domain.Colaborador;
import com.minsait.comunidad.domain.Curso;
import com.minsait.comunidad.dto.ColaboradorDto;
import com.minsait.comunidad.mapper.ColaboradorMapper;
import com.minsait.comunidad.mapper.ColaboradorMapperImpl;
import com.minsait.comunidad.repository.ColaboradorRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorServiceImpl implements ColaboradorServices {

    private ColaboradorRepository repository;
    private ColaboradorMapper mapper;

    public ColaboradorServiceImpl(ColaboradorRepository repository,ColaboradorMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<ColaboradorDto> findAllColaborador() {
        return mapper.toListDto(this.repository.findAll());
    }

    @Override
    public ColaboradorDto updateColaborador(ColaboradorDto colaboradorDto, Colaborador colaborador) {

        colaborador.setNombre(colaboradorDto.getNombre());
        colaborador.setApellidoPaterno(colaboradorDto.getApellidoPaterno());
        colaborador.setApellidoMaterno(colaboradorDto.getApellidoMaterno());
        if(colaboradorDto.getCurso() != null){
            String codigoCurso = colaboradorDto.getCurso().getCodigo();
            String nombreCurso = colaboradorDto.getCurso().getNombre();
            Curso curso = new Curso(codigoCurso,nombreCurso);
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
    public void deleteColaborador(String codigo) {
        this.repository.deleteById(new ObjectId(codigo));
    }

    @Override
    public Optional<Colaborador> findByCodigo(String codigo) {
        return repository.findById(new ObjectId(codigo));
    }
}
