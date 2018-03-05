package br.com.dev.agenda.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.dev.agenda.model.Contato;
import br.com.dev.agenda.repository.ContatoRepository;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ContatoResource {

	@Autowired
	private ContatoRepository contatoRepository;
	private final Logger log = LoggerFactory.getLogger(ContatoResource.class);
	@PostMapping("/novo-contato")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean salvar(@RequestBody Contato contato){
		try {
			contatoRepository.save(contato);
			return true;
		} catch (Exception e) {
			
			log.error(e.getMessage());
			return false;
		}
		
	}
	
	@GetMapping("/atualizar-contato/{id}")
	public Contato atualizar(@PathVariable Long id){
		System.out.println(id);
		Contato contato = contatoRepository.getOne(id);
		return contato;
	}
	
	@GetMapping("/remover-contato/{id}")
	public boolean excluir(@PathVariable Long id){
		try {
			contatoRepository.delete(id);
			return true;
		} catch (Exception e) {
			
			log.error(e.getMessage());
			return false;
		}
		
	}
	
	@GetMapping("/contatos")
	public List<Contato> listar(){
		List<Contato> contatos = contatoRepository.findAll();
		return contatos;
	}
}
