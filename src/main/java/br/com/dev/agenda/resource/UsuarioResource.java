package br.com.dev.agenda.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.agenda.model.Usuario;
import br.com.dev.agenda.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/registrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@RequestBody Usuario usuario) {
		System.out.println("contato: " + usuario);
		usuarioRepository.save(usuario);
		return usuario;
	}

	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario usuario) {
		
			Usuario usuarioBanco = usuarioRepository.findByEmail(usuario.getEmail());
			Usuario user = new Usuario();
			//verifica se usuário existe no banco
			if(usuarioBanco != null && usuarioBanco.getId() != null){
				//valida os campos digitados com os campos inseridos no banco
				if (usuarioBanco.getEmail().equals(usuario.getEmail()) && usuarioBanco.getSenha().equals(usuario.getSenha())) {
					user.setId(usuarioBanco.getId());
					user.setNome(usuarioBanco.getNome());
					user.setEmail(usuarioBanco.getEmail());
					return user;
				}else{
					return new Usuario();	
				}
			}else{
				return new Usuario();		
		}
		
	}

	public void atualizar(Long id) {
		Usuario usuario = usuarioRepository.getOne(id);
	}

	public void excluir(Long id) {
		usuarioRepository.delete(id);
	}

	@GetMapping("/usuarios")
	public void listar() {
		List<Usuario> usuarios = usuarioRepository.findAll();
	}
}
