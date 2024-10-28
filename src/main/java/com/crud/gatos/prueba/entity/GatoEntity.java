package com.crud.gatos.prueba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import java.util.UUID;

@Entity
@Table(name = "gatos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int edad;
    private String raza;

}
