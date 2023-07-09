package br.com.kentec.atendetec.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="painel_04")
@SuppressWarnings("serial")
public class Painel04 implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="fila_id", nullable = false, length = 10)
	private Long filaId;
	
	@Column(name="senha", nullable = false, length = 10)
	private String senha;
	
	@Column(name="guiche", nullable = false, length = 64)
	private String guiche;
	
	@Column(name="servico", nullable = false, length = 100)
	private String servico;
	
	@Column(name="unidade", nullable = false, length = 64)
	private String unidade;
	
	@Column(name="chamada", nullable = true)
	private LocalDateTime chamada;
	
	@Column(name="prioridade", nullable = true, length = 30)
	private String prioridade;
	
	@Column(name="chamar", nullable = true)
	private Boolean chamar;
	
	public Painel04() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFilaId() {
		return filaId;
	}

	public void setFilaId(Long filaId) {
		this.filaId = filaId;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getGuiche() {
		return guiche;
	}

	public void setGuiche(String guiche) {
		this.guiche = guiche;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public LocalDateTime getChamada() {
		return chamada;
	}

	public void setChamada(LocalDateTime chamada) {
		this.chamada = chamada;
	}

	public Boolean getChamar() {
		return chamar;
	}

	public void setChamar(Boolean chamar) {
		this.chamar = chamar;
	}

	@Override
	public String toString() {
		return "Painel04 [id=" + id + ", filaId=" + filaId + ", senha=" + senha + ", guiche=" + guiche + ", servico="
				+ servico + ", unidade=" + unidade + ", chamada=" + chamada + ", prioridade=" + prioridade + ", chamar="
				+ chamar + "]";
	}
}
