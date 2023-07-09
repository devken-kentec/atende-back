package br.com.kentec.atendetec.domain;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="grade")
@SuppressWarnings("serial")
public class Grade implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="intervalo", nullable = false, length = 11)
	private Integer intervalo;
	
	@Column(name="quantidade", nullable = false, length = 11)
	private Integer quantidade;
	
	@Column(name="corr_hora", nullable = false, length = 11)
	private Integer correcaoHora;
	
	@Column(name="hora_incial", nullable = false, length = 5)
	private String horaInicial;
	
	@Column(name="hora_final", nullable = false, length = 5)
	private String horaFinal;
	
	@Column(name="configurado", length = 1)
	private String configurado;
	
	@Column(name="gerado", length = 1)
	private String gerado;
	
	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private Unidade unidade = new Unidade();
	
	@ManyToOne
	@JoinColumn(name = "calendario_id")
	private Calendario calendario = new Calendario();
	
	@ManyToOne
	@JoinColumn(name = "servico_id")
	private Servico servico = new Servico();
	
	public Grade() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
	
	public Unidade getUnidade() {
		return unidade;
	}
	
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	public Calendario getCalendario() {
		return calendario;
	}
	
	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	
	public Servico getServico() {
		return servico;
	}
	
	public void setServico(Servico servico) {
		this.servico = servico;
	}	

	public Integer getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}
	
	public String getConfigurado() {
		return configurado;
	}

	public void setConfigurado(String configurado) {
		this.configurado = configurado;
	}

	public Integer getCorrecaoHora() {
		return correcaoHora;
	}

	public void setCorrecaoHora(Integer correcaoHora) {
		this.correcaoHora = correcaoHora;
	}

	public String getGerado() {
		return gerado;
	}

	public void setGerado(String gerado) {
		this.gerado = gerado;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", intervalo=" + intervalo + ", quantidade=" + quantidade + ", correcaoHora="
				+ correcaoHora + ", horaInicial=" + horaInicial + ", horaFinal=" + horaFinal + ", configurado="
				+ configurado + ", gerado=" + gerado + ", unidade=" + unidade + ", calendario=" + calendario
				+ ", servico=" + servico + "]";
	}
}
