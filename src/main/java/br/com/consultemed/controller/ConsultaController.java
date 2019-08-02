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
import br.com.consultemed.model.Medico;
import br.com.consultemed.model.Paciente;
import br.com.consultemed.service.ConsultaService;
import br.com.consultemed.service.IConsulta;
import br.com.consultemed.service.IMedico;
import br.com.consultemed.service.IPaciente;
import br.com.consultemed.service.MedicoService;
import br.com.consultemed.service.PacienteService;
import br.com.consultemed.utils.Constantes;

/**
 * Servlet implementation class ConsultaController
 */
@WebServlet("/admin/consultas")
public class ConsultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IConsulta cservice;
	@Inject
	private IPaciente pservice;
	@Inject
	private IMedico mservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaController() {
       this.cservice = new ConsultaService();
       this.pservice = new PacienteService();
       this.mservice = new MedicoService();
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
			case Constantes.LISTAR:
				list(request, response);
				break;	
			case Constantes.LISTARPACIENTES:
				listPacientes(request, response);
				break;	
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void novo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_CONSULTAS);
		Collection<Paciente> pacientes = this.pservice.listar();
		Collection<Medico> medicos = this.mservice.listar();
		request.setAttribute("pacientes", pacientes);
		request.setAttribute("medicos", medicos);
		rd.forward(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.CONSULTAS);
		Collection<Consulta> consultas = this.cservice.listar();
		request.setAttribute("consultas", consultas);
		rd.forward(request, response);		
	}
	
	private void listPacientes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.PACIENTES);
		Collection<Paciente> pacientes = this.pservice.listar();
		request.setAttribute("pacientes", pacientes);
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
