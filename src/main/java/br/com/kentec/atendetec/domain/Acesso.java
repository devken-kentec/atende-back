package br.com.kentec.atendetec.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="acesso")
@SuppressWarnings("serial")
public class Acesso implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="senha", nullable = false, length = 10)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="servidor_id", nullable = false)
	private Servidor servidor = new Servidor();
	
	@ManyToOne
	@JoinColumn(name="unidade_id", nullable = false)
	private Unidade unidade = new Unidade();
	
	@ManyToOne
	@JoinColumn(name="role_id", nullable = false)
	private Role role = new Role();
	
	public Acesso() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Acesso [id=" + id + ", senha=" + senha + ", servidor=" + servidor + ", unidade=" + unidade + ", role="
				+ role + "]";
	}
}
