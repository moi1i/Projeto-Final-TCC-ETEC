package br.com.pinguins.tcc.backend.repositories;

import br.com.pinguins.tcc.backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u.email  FROM Usuario AS u WHERE u.email = ?1")
    Usuario findByEmail(String email);
}
