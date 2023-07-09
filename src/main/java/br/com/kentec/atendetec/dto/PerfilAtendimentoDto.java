package br.com.kentec.atendetec.dto;

import br.com.kentec.atendetec.domain.PerfilAtendimento;

public class PerfilAtendimentoDto {
	
	private Long id;
	private String servidor;
	private String unidade;
	private String role;
	private String detalhamento;
	private String servico;
	
	public PerfilAtendimentoDto(PerfilAtendimento pa) {
		this.id = pa.getId();
		this.servidor = pa.getAcesso().getServidor().getMatricula();
		this.unidade = pa.getAcesso().getUnidade().getSigla();
		this.role = pa.getAcesso().getRole().getDescricao();
		this.detalhamento = pa.getDetalhamentoServico().getDescricao();
		this.servico = pa.getDetalhamentoServico().getServico().getSigla();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getServidor() {
		return servidor;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDetalhamento() {
		return detalhamento;
	}
	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	
	@Override
	public String toString() {
		return "PerfilAtendimentoDto [id=" + id + ", servidor=" + servidor + ", unidade=" + unidade + ", role=" + role
				+ ", detalhamento=" + detalhamento + ", servico=" + servico + "]";
	}

}
