package br.com.consultemed.controller;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.consultemed.model.DiasAtendimento;
import br.com.consultemed.model.Medico;
import br.com.consultemed.service.MedicoService;
import br.com.consultemed.utils.Constantes;

/**
 * Servlet implementation class MedicoController
 */
@WebServlet("/admin/medicos")
public class MedicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Inject
	private MedicoService business;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicoController() {
        super();
        this.business = new MedicoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter(Constantes.ACTION);

		try {
			switch (action) {
			case Constantes.NOVO:
				novo(request, response);
				break;
			case Constantes.DELETE:
				delete(request, response);
				break;
			case Constantes.EDITAR:
				editar(request, response);
				break;
			case Constantes.LISTAR :
				list(request, response);
				break;			
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_MEDICOS);
		rd.forward(request, response);
	}	

	/**
	 * Metodo que lista todos os médicos do sistema
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.MEDICOS);
		Collection<Medico> medicos = this.business.listar();
		request.setAttribute("medicos", medicos);
		rd.forward(request, response);
		
	}
	
	/**
	 * Metodo que remove um medico do banco de dados
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		this.business.remover(Long.parseLong(request.getParameter("id")));
		request.setAttribute("remover", Constantes.MEDICO_REMOVIDO);
		list(request, response);
	}

	/**
	 * Metodo que edita um medico
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void editar(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		Medico medico = (Medico) this.business.buscar(Long.parseLong(request.getParameter("id")));
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_MEDICOS);
		request.setAttribute("medico", medico);
		rd.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Medico medico = new Medico();
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String crm = request.getParameter("crm");		
		String especialidade = request.getParameter("especialidade");
		
		String id = request.getParameter("id");			
			
		medico.setNome(nome);
		medico.setCpf(cpf);
		medico.setCrm(crm);
		medico.setEspecialidade(especialidade);
		

		Boolean segunda = Boolean.valueOf(request.getParameter("segunda"));
		Boolean terca = Boolean.valueOf(request.getParameter("terca"));
		Boolean quarta = Boolean.valueOf(request.getParameter("quarta"));
		Boolean quinta = Boolean.valueOf(request.getParameter("quinta"));
		Boolean sexta = Boolean.valueOf(request.getParameter("sexta"));
		Boolean sabado = Boolean.valueOf(request.getParameter("sabado"));
		Boolean domingo = Boolean.valueOf(request.getParameter("domingo"));
		
		DiasAtendimento dia = new  DiasAtendimento(segunda, terca, quarta, quinta, sexta, sabado, domingo);
		
		medico.setDiasAtendimento(dia);
		
		try {
			
			if(id != "" && id != null) {
				medico.setId(Long.parseLong(id));
				this.business.alterar(medico);
				request.setAttribute("editado", nome + " " +Constantes.USUARIO_EDITADO);
			}else {
				this.business.salvar(medico);
				request.setAttribute("cadastro", nome + " " + Constantes.USUARIO_SUCESSO);			
			}
		
			list(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
