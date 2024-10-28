package com.crud.gatos.prueba.controller;

import com.crud.gatos.prueba.dtos.GatoDto;
import com.crud.gatos.prueba.dtos.GatoRequestDto;
import com.crud.gatos.prueba.entity.GatoEntity;
import com.crud.gatos.prueba.repository.GatoRepository;
import com.crud.gatos.prueba.service.GatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gato")
public class GatoController {

    @Autowired
    private GatoService gatoService;

    @GetMapping("")
    public List<GatoDto> obtenerGatos(){
        List<GatoDto> gatos = gatoService.obtenerGatos();
        return gatos;
    }

    @GetMapping("/{id}")
    public GatoDto obtenerGato(@PathVariable Long id){
        GatoDto gato = gatoService.obtenerGato(id);
        return gato;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public GatoDto guardarGato(@RequestBody GatoRequestDto gato){
        GatoDto gatodto = gatoService.guardarGato(gato);
        return gatodto;
    }

    @PutMapping("/{id}")
    public GatoDto actualizarGato(@PathVariable Long id, @RequestBody GatoRequestDto gato){

        GatoDto gatoDto = gatoService.actualizarGato(id, gato);
        return  gatoDto;
    }

    @DeleteMapping("/{id}")
    public void eliminarGato(@PathVariable Long id){
        gatoService.eliminarGato(id);
    }
}
