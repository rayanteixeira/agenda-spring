package br.com.dev.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev.agenda.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
}
