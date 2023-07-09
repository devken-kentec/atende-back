package br.com.kentec.atendetec.domain;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="perfil_atendimento")
@SuppressWarnings("serial")
public class PerfilAtendimento implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="acesso_id", nullable = false)
	private Acesso acesso = new Acesso();
	
	@ManyToOne
	@JoinColumn(name="detalhe_servico_id", nullable = false)
	private DetalhamentoServico detalhamentoServico = new DetalhamentoServico();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	public DetalhamentoServico getDetalhamentoServico() {
		return detalhamentoServico;
	}

	public void setDetalhamentoServico(DetalhamentoServico detalhamentoServico) {
		this.detalhamentoServico = detalhamentoServico;
	}

	@Override
	public String toString() {
		return "PerfilAtendimento [id=" + id + ", acesso=" + acesso + ", detalheServico=" + detalhamentoServico + "]";
	}

}
