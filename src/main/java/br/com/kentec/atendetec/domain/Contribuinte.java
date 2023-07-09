package br.com.kentec.atendetec.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="contribuinte")
@SuppressWarnings("serial")
public class Contribuinte implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 128)
	private String nome;
	
	@Column(name = "cpf_cnpj", nullable = false, length = 15)
	private String cpfCnpj;
	
	@Column(name = "email", nullable = false, length = 256)
	private String email;
	
	@Column(name = "fone", nullable = false, length = 12)
	private String fone;
	
	@Column(name = "senha", nullable = false, length = 6)
	private String senha;
	
	public Contribuinte() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Contribuinte [id=" + id + ", nome=" + nome + ", cpfCnpj=" + cpfCnpj + ", email=" + email + ", fone="
				+ fone + ", senha=" + senha + "]";
	}
	
}
