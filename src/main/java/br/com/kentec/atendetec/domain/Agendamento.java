package br.com.kentec.atendetec.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="agendamento")
@SuppressWarnings("serial")
public class Agendamento implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name = "horario", nullable = false, length = 5)
	private String horario;
	
	@Column(name = "sequencial", nullable = false, length = 5)
	private String sequencial;
	
	@Column(name="prioridade", nullable = true, length = 30)
	private String prioridade;
	
	@Column(name = "senha", nullable = true, length = 10)
	private String senha;
	
	@Column(name="status_agendamento", nullable = true, length = 30)
	private String statusAgendamento;
	
	@ManyToOne
	@JoinColumn(name = "grade_id")
	private Grade grade = new Grade();
	
	@ManyToOne
	@JoinColumn(name="detalhe_serv_id", nullable = true)
	private DetalhamentoServico detalhamentoServico = new DetalhamentoServico();
	
	@ManyToOne
	@JoinColumn(name = "contribuinte_id", nullable = true)
	private Contribuinte contribuinte = new Contribuinte();
	
	@Column(name="aceite", nullable = true)
	private Boolean aceite;
	
	public Agendamento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getSequencial() {
		return sequencial;
	}

	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(String statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public DetalhamentoServico getDetalhamentoServico() {
		return detalhamentoServico;
	}

	public void setDetalhamentoServico(DetalhamentoServico detalhamentoServico) {
		this.detalhamentoServico = detalhamentoServico;
	}

	public Contribuinte getContribuinte() {
		return contribuinte;
	}

	public void setContribuinte(Contribuinte contribuinte) {
		this.contribuinte = contribuinte;
	}
	
	
	public Boolean getAceite() {
		return aceite;
	}

	public void setAceite(Boolean aceite) {
		this.aceite = aceite;
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", horario=" + horario + ", sequencial=" + sequencial + ", prioridade="
				+ prioridade + ", senha=" + senha + ", statusAgendamento=" + statusAgendamento + ", grade=" + grade
				+ ", detalhamentoServico=" + detalhamentoServico + ", contribuinte=" + contribuinte + ", aceite="
				+ aceite + "]";
	}
	
}
