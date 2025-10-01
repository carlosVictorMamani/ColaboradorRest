package com.minsait.comunidad.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorDto {
    private String id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private CursoDto curso;
}
