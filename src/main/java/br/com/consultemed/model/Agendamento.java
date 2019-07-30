package br.com.consultemed.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Table(name="tb_agendamento")
@Entity
public class Agendamento extends AbstractEntity<Long> {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_agendamento")
	private Date dataAgendamento;
	
	@OneToOne
	private Consulta consulta;
	
	@OneToOne
	private Paciente paciente;	

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	

}
