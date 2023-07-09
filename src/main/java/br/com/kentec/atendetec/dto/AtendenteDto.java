package br.com.kentec.atendetec.dto;

import br.com.kentec.atendetec.domain.Atendente;

public class AtendenteDto {
	
	private Long id;
	private String statusAtendente;
	private String nome;
	private String matricula;
	private String role;
	private String guiche;
	
	public AtendenteDto(Atendente a) {
		this.id = a.getId();
		this.statusAtendente = a.getStatusAtendente();
		this.matricula = a.getAcesso().getServidor().getMatricula();
		this.nome = a.getAcesso().getServidor().getNome();
		this.role = a.getAcesso().getRole().getDescricao();
		this.guiche = a.getGuiche().getDescricao();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStatusAtendente() {
		return statusAtendente;
	}
	
	public void setStatusAtendente(String statusAtendente) {
		this.statusAtendente = statusAtendente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getGuiche() {
		return guiche;
	}
	
	public void setGuiche(String guiche) {
		this.guiche = guiche;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "AtendenteDto [id=" + id + ", statusAtendente=" + statusAtendente + ", nome=" + nome + ", matricula="
				+ matricula + ", role=" + role + ", guiche=" + guiche + "]";
	}
}
