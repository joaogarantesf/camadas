package br.org.serratec.backend.dto;

import br.org.serratec.backend.model.Usuario;

public class UsuarioMostrarDTO {
	private Long id;
	private String nome;
	private String email;
	
	public UsuarioMostrarDTO() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioMostrarDTO(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public UsuarioMostrarDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
