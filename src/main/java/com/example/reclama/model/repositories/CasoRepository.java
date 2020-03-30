package com.example.reclama.model.repositories;

import com.example.reclama.model.entities.Caso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasoRepository extends JpaRepository<Caso, Long> {
}
