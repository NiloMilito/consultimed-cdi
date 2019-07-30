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

import br.com.consultemed.model.Exame;
import br.com.consultemed.service.ExameService;
import br.com.consultemed.service.IExameService;
import br.com.consultemed.utils.Constantes;

/**
 * Servlet implementation class ExameController
 */
@WebServlet("/admin/exames")
public class ExameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IExameService eservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExameController() {
        this.eservice = new ExameService();
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
				doDelete(request, response);
				break;
			case Constantes.EDITAR:
				doPut(request, response);
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
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_EXAMES);
		rd.forward(request, response);
	}
	
	/**
	 * Metodo que lista todos os médicos do sistema
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.EXAMES);
		Collection<Exame> exames = this.eservice.listar();
		request.setAttribute("exames", exames);
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Exame exame = new Exame();
		
		String id = request.getParameter("id");	
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		
		exame.setNome(nome);
		exame.setTipo(tipo);
		
		try {
			if(id != null || id != "") {
				exame.setId(Long.parseLong(id));
				this.eservice.alterar(exame);
			} 
			this.eservice.salvar(exame);
			
			list(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Exame exame = new Exame();
		try {
			exame = this.eservice.buscar(Long.parseLong(request.getParameter("id")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_EXAMES);
		request.setAttribute("exame", exame);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.eservice.remover(Long.parseLong(request.getParameter("id")));
			list(request, response);
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		request.setAttribute("remover", Constantes.CONTATO_REMOVIDO);	
	}
	
	

}
