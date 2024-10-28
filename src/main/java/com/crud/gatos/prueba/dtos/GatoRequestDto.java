package com.crud.gatos.prueba.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatoRequestDto {
    private String nombre;
    private int edad;
    private String raza;
}
