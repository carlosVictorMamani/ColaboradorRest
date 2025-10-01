package com.minsait.comunidad.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

import com.minsait.comunidad.domain.Colaborador;
import com.minsait.comunidad.dto.ColaboradorDto;
import com.minsait.comunidad.services.ColaboradorServices;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {
        
    private ColaboradorServices colaboradorServices;
    
    public ColaboradorController(ColaboradorServices colaboradorServices) {
        this.colaboradorServices = colaboradorServices;
    }
    @PostMapping
    public ResponseEntity<ColaboradorDto> save(@RequestBody ColaboradorDto colaboradorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorServices.saveColaborador(colaboradorDto));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<?> update(@PathVariable String codigo, @RequestBody ColaboradorDto colaborador) {
       
        Optional<Colaborador> objColaborador = colaboradorServices.findByCodigo(codigo);
        if(objColaborador.isPresent()) {
            return ResponseEntity.ok(colaboradorServices.updateColaborador(colaborador, objColaborador.get()));
        }
        return ResponseEntity.notFound().build();
        
    }
    
  

}
