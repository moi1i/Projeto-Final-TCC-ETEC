package br.com.pinguins.tcc.backend.repositories;

import br.com.pinguins.tcc.backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
