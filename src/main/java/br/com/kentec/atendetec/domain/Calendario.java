package br.com.kentec.atendetec.domain;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="calendario")
@SuppressWarnings("serial")
public class Calendario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name = "dia", nullable = true, length = 10)
	private String dia;
	
	@Column(name = "observacao", nullable = true, length = 128)
	private String observacao;
	
	@Column(name = "status_calendario", nullable = true, length = 10)
	private String statusCalendario;
	
	public Calendario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatusCalendario() {
		return statusCalendario;
	}

	public void setStatusCalendario(String statusCalendario) {
		this.statusCalendario = statusCalendario;
	}

	@Override
	public String toString() {
		return "Calendario [id=" + id + ", dia=" + dia + ", observacao=" + observacao + ", statusCalendario="
				+ statusCalendario + "]";
	}
}
