package br.com.dev.agenda.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String senha;

	@NotEmpty
	private String email;

	// @OneToMany(cascade = {CascadeType.ALL})
	// private List<Contato> contatos;

	// @OneToMany(mappedBy = "produto", cascade = { CascadeType.PERSIST,
	// CascadeType.MERGE })
	// private List<Movimentacao> movimentacoes = new ArrayList<>();

	public Usuario() {

	}

	public Usuario(String nome, String email) {

	}

	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	/*
	 * public List<Contato> getContatos() { return contatos; }
	 * 
	 * public void setContatos(List<Contato> contatos) { this.contatos =
	 * contatos; }
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", email=" + email + "]";
	}

}