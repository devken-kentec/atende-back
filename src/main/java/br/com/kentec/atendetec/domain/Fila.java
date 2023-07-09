package br.com.kentec.atendetec.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="fila")
@SuppressWarnings("serial")
public class Fila implements Serializable {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="ativacao", nullable = false)
	private LocalDateTime ativacao;
	
	@Column(name="chamada", nullable = true)
	private LocalDateTime chamada;
	
	@Column(name="inicio", nullable = true)
	private LocalDateTime inicio;
	
	@Column(name="finalizado", nullable = true)
	private LocalDateTime finalizado;
	
	@Column(name="avaliacao", nullable = true, length = 15)
	private String avaliacao;
	
	@Column(name="status_fila", nullable = true, length = 15)
	private String statusFila;
	
	@Column(name="identificador", nullable = false, length = 15)
	private Long identificador;
	
	@Column(name="senha", nullable = false, length = 10)
	private String senha;
	
	@Column(name="nome", nullable = false, length = 128)
	private String nome;
	
	@Column(name="cpfCnpj", nullable = false, length = 15)
	private String cpfCnpj;
	
	@Column(name="unidade", nullable = false, length = 64)
	private String unidade;
	
	@Column(name="data", nullable = false, length = 10)
	private String data;
	
	@Column(name="horario", nullable = false, length = 5)
	private String horario;
	
	@Column(name="servico", nullable = false, length = 255)
	private String servico;
	
	@Column(name="detalhamentoServico", nullable = false, length = 100)
	private String detalhamentoServico;
	
	@Column(name="statusAgendamento", nullable = false, length = 30)
	private String statusAgendamento;
	
	@Column(name="prioridade", nullable = false, length = 30)
	private String prioridade;
	
	@ManyToOne
	@JoinColumn(name="atendente_id", nullable = true)
	private Atendente atendente = new Atendente();
	
	public Fila() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getAtivacao() {
		return ativacao;
	}

	public void setAtivacao(LocalDateTime ativacao) {
		this.ativacao = ativacao;
	}

	public LocalDateTime getChamada() {
		return chamada;
	}

	public void setChamada(LocalDateTime chamada) {
		this.chamada = chamada;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(LocalDateTime finalizado) {
		this.finalizado = finalizado;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getStatusFila() {
		return statusFila;
	}

	public void setStatusFila(String statusFila) {
		this.statusFila = statusFila;
	}

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getDetalhamentoServico() {
		return detalhamentoServico;
	}

	public void setDetalhamentoServico(String detalhamentoServico) {
		this.detalhamentoServico = detalhamentoServico;
	}

	public String getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(String statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	@Override
	public String toString() {
		return "Fila [id=" + id + ", ativacao=" + ativacao + ", chamada=" + chamada + ", inicio=" + inicio
				+ ", finalizado=" + finalizado + ", avaliacao=" + avaliacao + ", statusFila=" + statusFila
				+ ", identificador=" + identificador + ", senha=" + senha + ", nome=" + nome + ", cpfCnpj=" + cpfCnpj
				+ ", unidade=" + unidade + ", data=" + data + ", horario=" + horario + ", servico=" + servico
				+ ", detalhamentoServico=" + detalhamentoServico + ", statusAgendamento=" + statusAgendamento
				+ ", priodidade=" + prioridade + ", atendente=" + atendente + "]";
	}
	
}