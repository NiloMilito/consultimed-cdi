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

import br.com.consultemed.model.Consulta;
import br.com.consultemed.service.ConsultaService;
import br.com.consultemed.service.IConsulta;
import br.com.consultemed.utils.Constantes;

/**
 * Servlet implementation class ConsultaController
 */
@WebServlet("/admin/consultas")
public class ConsultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IConsulta cservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaController() {
       this.cservice = new ConsultaService();
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
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_CONSULTAS);
		rd.forward(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.CONSULTAS);
		Collection<Consulta> exames = this.cservice.listar();
		request.setAttribute("exames", exames);
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Consulta consuta = new Consulta();
		
		String id = request.getParameter("id");	
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		
		
		try {
			if(id != null || id != "") {
				consuta.setId(Long.parseLong(id));
				this.cservice.alterar(consuta);
			} 
			this.cservice.salvar(consuta);
			
			list(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Consulta exame = new Consulta();
		try {
			exame = this.cservice.buscar(Long.parseLong(request.getParameter("id")));
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
		// TODO Auto-generated method stub
	}

}
