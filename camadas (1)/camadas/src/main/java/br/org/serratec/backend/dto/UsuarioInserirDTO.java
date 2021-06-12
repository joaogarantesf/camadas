package br.org.serratec.backend.dto;

import br.org.serratec.backend.model.Usuario;

public class UsuarioInserirDTO {
	private String email;
	private String nome;
	private String senha;
	
	public UsuarioInserirDTO() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioInserirDTO(Usuario usuario) {
		this.email = usuario.getEmail();
		this.nome = usuario.getNome();
		this.senha = usuario.getSenha();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}
