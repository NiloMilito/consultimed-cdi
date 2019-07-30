package br.com.consultemed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name="tb_medico")
@Entity
@NamedQueries({ @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")})
	
public class Medico extends Pessoa {

	@Column(name="crm", unique=true)
	private String crm;
	
	private String especialidade;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="diasAtendimento_id")
	private DiasAtendimento diasAtendimento;
	
	public Medico() {
		
	}

	public Medico(String crm, DiasAtendimento diasAtendimento,String especialidade) {
		super();
		this.crm = crm;
		this.diasAtendimento = diasAtendimento;
		this.especialidade = especialidade;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public DiasAtendimento getDiasAtendimento() {
		return diasAtendimento;
	}

	public void setDiasAtendimento(DiasAtendimento diasAtendimento) {
		this.diasAtendimento = diasAtendimento;
	}	
	
}
