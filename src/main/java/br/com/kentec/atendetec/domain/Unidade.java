package br.com.kentec.atendetec.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="unidade")
@SuppressWarnings("serial")
public class Unidade implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = true)
	private Long id;
	
	@Column(name="sigla", nullable = false, length = 5)
	private String sigla;
	
	@Column(name="descricao", nullable = false, length = 64)
	private String descricao;
	
	@Column(name="endereco", nullable = false, length = 128)
	private String endereco;
	
	@Column(name="codigo", nullable = false, length = 10)
	private String codigo;
	
	@Column(name="telefone", nullable = false, length = 15)
	private Long telefone;
	
	public Unidade() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Long getTelefone() {
		return telefone;
	}
	
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Unidade [id=" + id + ", sigla=" + sigla + ", descricao=" + descricao + ", endereco=" + endereco
				+ ", codigo=" + codigo + ", telefone=" + telefone + "]";
	}
}
