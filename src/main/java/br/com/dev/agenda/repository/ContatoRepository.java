package br.com.dev.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.dev.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

	@Query(value = "SELECT * FROM contato c WHERE c.usuario_id = :id", nativeQuery = true)
	List<Contato> findByUser(@Param("id") Long id);
}
