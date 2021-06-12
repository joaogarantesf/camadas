package br.org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.config.MailConfig;
import br.org.serratec.backend.dto.UsuarioInserirDTO;
import br.org.serratec.backend.dto.UsuarioMostrarDTO;
import br.org.serratec.backend.exception.EmailException;
import br.org.serratec.backend.model.Usuario;
import br.org.serratec.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MailConfig mailConfig;
	
	public List<UsuarioMostrarDTO> listar(){
		List<UsuarioMostrarDTO> usuarioDTOs = new ArrayList<UsuarioMostrarDTO>();
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		for(Usuario usuario: usuarios) {
			UsuarioMostrarDTO dto = new UsuarioMostrarDTO(usuario);
			usuarioDTOs.add(dto);
		}
		return usuarioDTOs;
	}
	
	public UsuarioMostrarDTO inserir(UsuarioInserirDTO usuarioInserirDTO) throws EmailException{
		Usuario u = usuarioRepository.findByEmail(usuarioInserirDTO.getEmail());
		if(u != null) {
			throw new EmailException ("Email existente! Insira outro");
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setPerfil("Usuário Padrão");
		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha()));
		usuario = usuarioRepository.save(usuario);
		mailConfig.enviarEmail(usuarioInserirDTO.getEmail(), "Cadastro de Usuário!", usuario.toString());
		return new UsuarioMostrarDTO (usuario);
	}
}
