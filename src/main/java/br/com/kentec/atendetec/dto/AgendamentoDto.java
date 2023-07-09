package br.com.kentec.atendetec.dto;

public class AgendamentoDto {
	
	private Long id;
	private Long contribuinte; 
	private Long detalhamentoServico;
	private String prioridade;
	private Boolean aceite;
	
	public AgendamentoDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContribuinte() {
		return contribuinte;
	}

	public void setContribuinte(Long contribuinte) {
		this.contribuinte = contribuinte;
	}

	public Long getDetalhamentoServico() {
		return detalhamentoServico;
	}

	public void setDetalhamentoServico(Long detalhamentoServico) {
		this.detalhamentoServico = detalhamentoServico;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public Boolean getAceite() {
		return aceite;
	}

	public void setAceite(Boolean aceite) {
		this.aceite = aceite;
	}
}
