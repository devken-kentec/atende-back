package br.com.kentec.atendetec.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="servidor")
@SuppressWarnings("serial")
public class Servidor implements Serializable {

	@Id
	@Column(name ="id", nullable = false, length = 10)
	private String matricula;
	
	@Column(name = "nome", nullable = false, length = 128)
	private String nome;
	
	@Column(name = "cpf", nullable = true, length = 15)
	private String cpf;
	
	@Column(name = "lotacao", nullable = true, length = 256) 
	private String lotacao;
	
	@Column(name = "telefone", nullable = true, length = 20)
	private String telefone;
	
	@Column(name = "email", nullable = true, length = 50)
	private String email;
	
	@Column(name = "status_servidor")
	private String statusServidor;
	
	public Servidor() {
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatusServidor() {
		return statusServidor;
	}

	public void setStatusServidor(String statusServidor) {
		this.statusServidor = statusServidor;
	}

	@Override
	public String toString() {
		return "Servidor [matricula=" + matricula + ", nome=" + nome + ", cpf=" + cpf + ", lotacao=" + lotacao
				+ ", telefone=" + telefone + ", email=" + email + ", statusServidor=" + statusServidor + "]";
	}	
	
}
