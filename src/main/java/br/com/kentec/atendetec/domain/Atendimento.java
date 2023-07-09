package br.com.kentec.atendetec.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="atendimento")
@SuppressWarnings("serial")
public class Atendimento implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="descricao", nullable = true, length = 256)
	private String descricao;
	
	@Column(name="servidor", nullable = false, length = 64)
	private String servidor;
	
	@Column(name="realizado", nullable = true, length = 10)
	private String realizado;
	
	@ManyToOne
	@JoinColumn(name="detalhamento_servico_id", nullable = false)
	private DetalhamentoServico detalhamentoServico = new DetalhamentoServico();
	
	@ManyToOne
	@JoinColumn(name="fila_id", nullable = false)
	private Fila fila = new Fila();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public DetalhamentoServico getDetalhamentoServico() {
		return detalhamentoServico;
	}

	public void setDetalhamentoServico(DetalhamentoServico detalhamentoServico) {
		this.detalhamentoServico = detalhamentoServico;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
	public String getRealizado() {
		return realizado;
	}

	public void setRealizado(String realizado) {
		this.realizado = realizado;
	}

	@Override
	public String toString() {
		return "Atendimento [id=" + id + ", descricao=" + descricao + ", servidor=" + servidor + ", realizado="
				+ realizado + ", detalhamentoServico=" + detalhamentoServico + ", fila=" + fila + "]";
	}
	
}
