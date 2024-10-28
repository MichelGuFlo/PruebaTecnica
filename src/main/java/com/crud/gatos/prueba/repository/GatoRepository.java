package com.crud.gatos.prueba.repository;

import com.crud.gatos.prueba.entity.GatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatoRepository extends JpaRepository<GatoEntity, Long> {
}
