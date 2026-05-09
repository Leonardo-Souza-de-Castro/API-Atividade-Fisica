package com.itau.api.atividade_fisica.Repository;

import com.itau.api.atividade_fisica.Entity.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
}
