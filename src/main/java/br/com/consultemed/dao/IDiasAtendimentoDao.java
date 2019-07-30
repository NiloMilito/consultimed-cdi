package br.com.consultemed.dao;

import java.util.Collection;

import br.com.consultemed.model.DiasAtendimento;

public interface IDiasAtendimentoDao extends GenericDao<DiasAtendimento, Long>{
		
public void save(DiasAtendimento diasAtendimento) throws Exception;
	
	public DiasAtendimento findById(Long id) throws Exception;
	
	public void deleteById(Long id) throws Exception;
	
	public void update(DiasAtendimento diasAtendimento) throws Exception;
	
	public Collection<DiasAtendimento> listAll() throws Exception;

}
