package com.parlatech.map.repositories;

import com.parlatech.map.domain.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  PontoRepository extends JpaRepository<Ponto, Integer> {
}
