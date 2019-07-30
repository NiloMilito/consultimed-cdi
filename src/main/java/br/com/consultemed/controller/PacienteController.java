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

import br.com.consultemed.model.Endereco;
import br.com.consultemed.model.Paciente;
import br.com.consultemed.service.PacienteService;
import br.com.consultemed.utils.Constantes;

/**
 * Servlet implementation class PacienteController
 */
@WebServlet("/admin/pacientes")
public class PacienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private PacienteService pservice;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteController() {
        this.pservice = new PacienteService();
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
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_PACIENTE);
		rd.forward(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.PACIENTES);
		Collection<Paciente> pacientes = this.pservice.listar();
		request.setAttribute("pacientes", pacientes);
		rd.forward(request, response);		
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		this.pservice.remover(Long.parseLong(request.getParameter("id")));
		request.setAttribute("remover", Constantes.CONTATO_REMOVIDO);
		list(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		Paciente paciente = this.pservice.buscar(Long.parseLong(request.getParameter("id")));
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_PACIENTE);
		request.setAttribute("paciente", paciente);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Paciente paciente = new Paciente();
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		
		String cep = request.getParameter("cep");
		String uf = request.getParameter("uf");
		String cidade = request.getParameter("cidade");
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		endereco.setEstado(uf);
		endereco.setCidade(cidade);
		endereco.setRua(rua);
		endereco.setNumero(numero);
		endereco.setBairro(bairro);		
		
		String id = request.getParameter("id");			
			
		paciente.setEndereco(endereco);
		paciente.setNome(nome);
		paciente.setCpf(cpf);
				
		try {
			
			if(id != "" && id != null) {
				paciente.setId(Long.parseLong(id));
				this.pservice.alterar(paciente);
				request.setAttribute("editado", nome + " " +Constantes.USUARIO_EDITADO);
			}else {
				this.pservice.salvar(paciente);
				request.setAttribute("cadastro", nome + " " + Constantes.USUARIO_SUCESSO);			
			}
		
			list(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
