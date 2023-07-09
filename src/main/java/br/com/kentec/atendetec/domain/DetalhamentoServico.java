package br.com.kentec.atendetec.domain;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="detalhamento_servico")
@SuppressWarnings("serial")
public class DetalhamentoServico implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="descricao", nullable = false, length = 100)
	private String descricao;
	
	@Column(name="vinculo", nullable = true, length = 15)
	private String vinculo;
	
	@Column(name="detalhamento", nullable = false, length = 100)
	private String detalhamento;

	@ManyToOne
	@JoinColumn(name="servico_id", nullable = false)
	private Servico servico = new Servico();
	
	public DetalhamentoServico() {
		
	}

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

	public String getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	public String getVinculo() {
		return vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	@Override
	public String toString() {
		return "DetalhamentoServico [id=" + id + ", descricao=" + descricao + ", vinculo=" + vinculo + ", detalhamento="
				+ detalhamento + ", servico=" + servico + "]";
	}
}
