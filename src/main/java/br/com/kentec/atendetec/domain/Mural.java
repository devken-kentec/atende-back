package br.com.kentec.atendetec.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="mural")
@SuppressWarnings("serial")
public class Mural implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 4)
	private Long id;
	
	@Column(name = "titulo", nullable = false, length = 32)
	private String titulo;
	
	@Column(name = "mensagem", nullable = false, length = 1000)
	private String mensagem;
	
	@Column(name = "status_mensagem", nullable = false, length = 10)
	private String statusMensagem;
	
	public Mural() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getStatusMensagem() {
		return statusMensagem;
	}

	public void setStatusMensagem(String statusMensagem) {
		this.statusMensagem = statusMensagem;
	}
	
}
