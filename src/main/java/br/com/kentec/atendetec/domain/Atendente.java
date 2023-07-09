package br.com.kentec.atendetec.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="atendente")
@SuppressWarnings("serial")
public class Atendente implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="status_atendente")
	private String statusAtendente;
	
	@OneToOne
	@JoinColumn(name="acesso_id")
	private Acesso acesso = new Acesso();
	
	@OneToOne
	@JoinColumn(name="guiche_id")
	private Guiche guiche = new Guiche();
	
	public Atendente() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusAtendente() {
		return statusAtendente;
	}

	public void setStatusAtendente(String statusAtendente) {
		this.statusAtendente = statusAtendente;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	public Guiche getGuiche() {
		return guiche;
	}

	public void setGuiche(Guiche guiche) {
		this.guiche = guiche;
	}

	@Override
	public String toString() {
		return "Atendente [id=" + id + ", statusAtendente=" + statusAtendente + ", acesso=" + acesso + ", guiche="
				+ guiche + "]";
	}
}