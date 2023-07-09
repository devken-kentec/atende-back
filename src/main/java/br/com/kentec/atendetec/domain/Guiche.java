package br.com.kentec.atendetec.domain;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="guiche")
@SuppressWarnings("serial")
public class Guiche implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="descricao", nullable = true, length = 64)
	private String descricao;
	
	public Guiche() {
		
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

	@Override
	public String toString() {
		return "Guiche [id=" + id + ", descricao=" + descricao + "]";
	}
	
}

