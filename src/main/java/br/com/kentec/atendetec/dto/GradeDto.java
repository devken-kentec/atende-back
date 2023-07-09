package br.com.kentec.atendetec.dto;

public class GradeDto {
	private Long id;
	private Long dataInicial;
	private Long dataFinal;
	private String horaInicial;
	private String horaFinal;
	private Integer intervalo;
	private Integer correcaoHora;
	private String configurado;
	private String gerado;
	private Long unidade;
	private Long servico;
	private Integer quantidade;
		
	public GradeDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Long dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Long getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Long dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Integer getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}

	public Integer getCorrecaoHora() {
		return correcaoHora;
	}

	public void setCorrecaoHora(Integer correcaoHora) {
		this.correcaoHora = correcaoHora;
	}

	public String getConfigurado() {
		return configurado;
	}

	public void setConfigurado(String configurado) {
		this.configurado = configurado;
	}

	public String getGerado() {
		return gerado;
	}

	public void setGerado(String gerado) {
		this.gerado = gerado;
	}

	public Long getUnidade() {
		return unidade;
	}

	public void setUnidade(Long unidade) {
		this.unidade = unidade;
	}

	public Long getServico() {
		return servico;
	}

	public void setServico(Long servico) {
		this.servico = servico;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "GradeDto [id=" + id + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", horaInicial="
				+ horaInicial + ", horaFinal=" + horaFinal + ", intervalo=" + intervalo + ", correcaoHora="
				+ correcaoHora + ", configurado=" + configurado + ", gerado=" + gerado + ", unidade=" + unidade
				+ ", servico=" + servico + ", quantidade=" + quantidade + "]";
	}

}
