package com.crud.gatos.prueba.service;


import com.crud.gatos.prueba.dtos.GatoDto;
import com.crud.gatos.prueba.dtos.GatoRequestDto;
import com.crud.gatos.prueba.entity.GatoEntity;
import com.crud.gatos.prueba.repository.GatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GatoServiceImpl implements GatoService {

    @Autowired
    private GatoRepository gatoRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public List<GatoDto> obtenerGatos() {
        List<GatoEntity> gatos = gatoRepository.findAll();

        List<GatoDto> gatosDto = gatos.stream()
                .map(gatoEntity -> objectMapper.convertValue(gatoEntity, GatoDto.class))
                .toList();

         return gatosDto;
    }

    @Override
    public GatoDto obtenerGato(Long id) {
        GatoEntity gato = gatoRepository.findById(id).orElse(null);

        if(gato == null){
            return null;
        }
        return objectMapper.convertValue(gato, GatoDto.class);
    }

    @Override
    public GatoDto guardarGato(GatoRequestDto gato) {
        GatoEntity gatoEntity = objectMapper.convertValue(gato, GatoEntity.class);

        GatoEntity savedGatoEntity = gatoRepository.saveAndFlush(gatoEntity);

        GatoDto gatodto = objectMapper.convertValue(savedGatoEntity, GatoDto.class);
        return gatodto;
    }

    @Override
    public GatoDto actualizarGato(Long id, GatoRequestDto gato) {
        GatoEntity gatoEntity = gatoRepository.findById(id).orElse(null);

        if(gatoEntity == null){
            return null;
        }
        gatoEntity.setEdad(gato.getEdad());
        gatoEntity.setNombre(gato.getNombre());
        gatoEntity.setRaza(gato.getRaza());

        gatoRepository.save(gatoEntity);

        GatoDto gatoDto = objectMapper.convertValue(gatoEntity, GatoDto.class);
        return gatoDto;
    }

    @Override
    public void eliminarGato(Long id) {
        gatoRepository.deleteById(id);
    }
}
