package br.com.kentec.atendetec.dto;

import br.com.kentec.atendetec.domain.Fila;

public class FilaDto {
	
	private Long id;
	private String data;
	private String horario;
	private String senha;
	
	public FilaDto(Fila f) {
		this.id = f.getId();
		this.data = f.getData();
		this.horario = f.getHorario();
		this.senha = f.getSenha();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "FilaDto [id=" + id + ", data=" + data + ", horario=" + horario + ", senha=" + senha + "]";
	}
	
}
