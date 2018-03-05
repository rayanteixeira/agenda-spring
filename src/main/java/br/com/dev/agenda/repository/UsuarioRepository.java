package br.com.dev.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev.agenda.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
	
	/*@Query("select * from Contatos c where c.usuario_id = :id")
	Long countByMovimentacoesFromMesAno(@Param("dataMovimentacao") Integer dataMovimentacao, @Param("anoMovimentacao") Integer anoMovimentacao);
	*/
    
	/*@Query(value = "SELECT * FROM contato c WHERE c.usuario_id = :id", nativeQuery = true)
	List<Contato> findByUser(@Param("id") Long id);*/
	
/*	@Query(value = "SELECT * FROM usuario c WHERE c.usuario_id = :id", nativeQuery = true)
	Usuario findByUser(@Param("id") Long id);*/
}
