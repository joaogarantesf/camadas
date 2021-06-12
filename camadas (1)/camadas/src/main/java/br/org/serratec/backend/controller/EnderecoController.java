package br.org.serratec.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.backend.dto.EnderecoMostrarDTO;
import br.org.serratec.backend.service.EnderecoService;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;
	
	/*@GetMapping("{cep}")
	 * SEM DTO
	  public ResponseEntity<Endereco> buscar (@PathVariable String cep){
	 
		Endereco endereco = enderecoService.buscar(cep);
		if (endereco == null) {
			return ResponseEntity.notFound().build();
		}else
			return ResponseEntity.ok(endereco);
	}*/
	
	@GetMapping("{cep}")
	public ResponseEntity<EnderecoMostrarDTO> buscar (@PathVariable String cep){
		 
		EnderecoMostrarDTO enderecoMostrarDTO = enderecoService.buscar(cep);
		if (enderecoMostrarDTO == null) {
			return ResponseEntity.notFound().build();
		}else
			return ResponseEntity.ok(enderecoMostrarDTO);
}
}