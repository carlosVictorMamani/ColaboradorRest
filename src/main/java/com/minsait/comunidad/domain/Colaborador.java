package com.minsait.comunidad.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Colaborador")
public class Colaborador{
    
    @Id
    private ObjectId id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Curso curso;

}
