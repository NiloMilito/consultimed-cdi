package br.com.consultemed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name="tb_exame")
@Entity
public class Exame extends AbstractEntity<Long> {	
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="diagnostico")
	private String diagnostico;
	
	@Column(name="laudo")
	private String laudo;
	
	@Column(name="material_coletavel")
	private String materialColetavel;
	
	@ManyToOne
	@JoinColumn(name = "exames")
	private Consulta consulta;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMaterialColetavel() {
		return materialColetavel;
	}

	public void setMaterialColetavel(String materialColetavel) {
		this.materialColetavel = materialColetavel;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLaudo() {
		return laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}
