package br.com.consultemed.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public class Pessoa extends AbstractEntity<Long> {
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf", unique=true)
	private String cpf;
	
	public Pessoa() {
		
	}

	public Pessoa(Long id, String nome, String cpf) {		
		super.setId(id);
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
