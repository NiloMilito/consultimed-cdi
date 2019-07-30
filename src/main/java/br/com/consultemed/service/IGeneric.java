package br.com.consultemed.service;

import java.io.Serializable;
import java.util.Collection;

public interface IGeneric <T, ID extends Serializable>{
	
	public void salvar(T object) throws Exception;
	
	public void alterar(T object) throws Exception;
	
	public void remover (Long id) throws Exception;
	
	public T buscar(Long id) throws Exception;
	
	public Collection <T> listar() throws Exception;
	
}
