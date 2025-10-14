package com.minsait.comunidad.controller;

import com.minsait.comunidad.dto.ColaboradorDto;
import com.minsait.comunidad.services.ColaboradorServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {

    private ColaboradorServices colaboradorServices;

    public ColaboradorController(ColaboradorServices colaboradorServices){
        this.colaboradorServices = colaboradorServices;
    }

    @PostMapping
    public ResponseEntity<ColaboradorDto> save(@RequestBody ColaboradorDto colaboradorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorServices.saveColaborador(colaboradorDto));
    }


    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(colaboradorServices.findAllColaborador());
    }

}
