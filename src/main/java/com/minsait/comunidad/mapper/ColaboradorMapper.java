package com.minsait.comunidad.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.minsait.comunidad.domain.Colaborador;
import com.minsait.comunidad.domain.Curso;
import com.minsait.comunidad.dto.ColaboradorDto;
import com.minsait.comunidad.dto.CursoDto;

import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {
    
    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    ColaboradorDto toDto(Colaborador entity);
    
    @Mapping(target = "id", expression = "java(dto.getId() != null ? new org.bson.types.ObjectId(dto.getId()) : null)")
    Colaborador toEntity(ColaboradorDto dto);
    
    List<ColaboradorDto> toListDto(List<Colaborador> entities);
    List<Colaborador> toListEntity(List<ColaboradorDto> dtos);

     
    Curso toEntity(CursoDto dto);
    
    CursoDto toDto(Curso entity);

}


