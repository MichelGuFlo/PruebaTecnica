package com.crud.gatos.prueba.service;

import com.crud.gatos.prueba.dtos.GatoDto;
import com.crud.gatos.prueba.dtos.GatoRequestDto;

import java.util.List;

public interface GatoService {


    List<GatoDto> obtenerGatos();

    GatoDto obtenerGato(Long id);

    GatoDto guardarGato(GatoRequestDto gato);

    GatoDto actualizarGato(Long id, GatoRequestDto gato);

    void eliminarGato(Long id);

}
