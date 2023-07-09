package br.com.kentec.atendetec.dto;

import br.com.kentec.atendetec.domain.Atendimento;

public class AtendimentoDto {
	
	private Long id;
	private String descricao;
	private String realizado;
	private String servidor;
	private Long detalhamentoServico;
	private String detalhamentoServicoDescricao;
	private String avaliacao;
	private String senha;
	private String matricula;
	private String nomeServidor;
	private Long fila;
	
	public AtendimentoDto() {
		
	}
	
	public AtendimentoDto(Atendimento a) {
		this.id = a.getId();
		this.descricao = a.getDescricao();
		this.realizado = a.getRealizado();
		this.detalhamentoServicoDescricao = a.getDetalhamentoServico().getDescricao();
		this.avaliacao = a.getFila().getAvaliacao();
		this.senha = a.getFila().getSenha();
		this.matricula = a.getFila().getAtendente().getAcesso().getServidor().getMatricula();
		this.nomeServidor = a.getFila().getAtendente().getAcesso().getServidor().getNome();
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

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public Long getDetalhamentoServico() {
		return detalhamentoServico;
	}

	public void setDetalhamentoServico(Long detalhamentoServico) {
		this.detalhamentoServico = detalhamentoServico;
	}

	public Long getFila() {
		return fila;
	}

	public void setFila(Long fila) {
		this.fila = fila;
	}

	public String getRealizado() {
		return realizado;
	}

	public void setRealizado(String realizado) {
		this.realizado = realizado;
	}

	public String getDetalhamentoServicoDescricao() {
		return detalhamentoServicoDescricao;
	}

	public void setDetalhamentoServicoDescricao(String detalhamentoServicoDescricao) {
		this.detalhamentoServicoDescricao = detalhamentoServicoDescricao;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeServidor() {
		return nomeServidor;
	}

	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}

	@Override
	public String toString() {
		return "AtendimentoDto [id=" + id + ", descricao=" + descricao + ", realizado=" + realizado + ", servidor="
				+ servidor + ", detalhamentoServico=" + detalhamentoServico + ", detalhamentoServicoDescricao="
				+ detalhamentoServicoDescricao + ", avaliacao=" + avaliacao + ", senha=" + senha + ", matricula="
				+ matricula + ", nomeServidor=" + nomeServidor + ", fila=" + fila + "]";
	}
	
}
