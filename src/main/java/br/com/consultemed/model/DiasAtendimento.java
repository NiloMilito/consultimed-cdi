package br.com.consultemed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name="tb_dias_atendimento")
@Entity
public class DiasAtendimento extends AbstractEntity<Long> {

	@Column(name="segunda")
	private Boolean segunda;
	
	@Column(name="terca")
	private Boolean terca;
	
	@Column(name="quarta")
	private Boolean quarta;
	
	@Column(name="quinta")
	private Boolean quinta;
	
	@Column(name="sexta")
	private Boolean sexta;
	
	@Column(name="sabado")
	private Boolean sabado;
	
	@Column(name="domingo")
	private Boolean domingo;
	
	public DiasAtendimento() {
		
	}

	public DiasAtendimento(Boolean segunda, Boolean terca, Boolean quarta, Boolean quinta,
			Boolean sexta, Boolean sabado, Boolean domingo) {
		super();			
		this.segunda = segunda;
		this.terca = terca;
		this.quarta = quarta;
		this.quinta = quinta;
		this.sexta = sexta;
		this.sabado = sabado;
		this.domingo = domingo;
	}
	
	public Boolean getSegunda() {
		return segunda;
	}

	public void setSegunda(Boolean segunda) {
		this.segunda = segunda;
	}

	public Boolean getTerca() {
		return terca;
	}

	public void setTerca(Boolean terca) {
		this.terca = terca;
	}

	public Boolean getQuarta() {
		return quarta;
	}

	public void setQuarta(Boolean quarta) {
		this.quarta = quarta;
	}

	public Boolean getQuinta() {
		return quinta;
	}

	public void setQuinta(Boolean quinta) {
		this.quinta = quinta;
	}

	public Boolean getSexta() {
		return sexta;
	}

	public void setSexta(Boolean sexta) {
		this.sexta = sexta;
	}

	public Boolean getSabado() {
		return sabado;
	}

	public void setSabado(Boolean sabado) {
		this.sabado = sabado;
	}

	public Boolean getDomingo() {
		return domingo;
	}

	public void setDomingo(Boolean domingo) {
		this.domingo = domingo;
	}	
	
}
