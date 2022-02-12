package br.com.pinguins.tcc.backend.repositories;

import br.com.pinguins.tcc.backend.entities.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemedioRepository extends JpaRepository<Lembrete, Integer> {
}
