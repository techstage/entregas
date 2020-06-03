package io.techstage.entregas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.techstage.entregas.model.Entrega;

public interface Entregas extends JpaRepository<Entrega, Long>{
  
}