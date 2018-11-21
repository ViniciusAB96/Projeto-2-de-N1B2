package br.ftt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.ftt.dao.ComponenteDAO;
import br.ftt.model.ComponenteVO;

/**
 * Servlet implementation class Componente_Api
 */
@WebServlet("/Componente_Api")
public class Componente_Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Componente_Api() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: Componentes ").append(request.getContextPath());
		
		ComponenteDAO componenteDAO = new ComponenteDAO(); // objeto retorno do DAO
		ComponenteVO componente = new ComponenteVO();
		
		try {
			componente = componenteDAO.consulta(request.getParameter("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		} // VO recebendo DAO
		
		Gson componenteGson = new GsonBuilder().create(); //cria objeto Gson
		response.getWriter().append(componenteGson.toJson(componente, ComponenteVO.class));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComponenteDAO componenteDAO = new ComponenteDAO(); // objeto retorno do DAO
		try {
			componenteDAO.excluir(request.getParameter("id"));
		} catch (SQLException erro) {
			erro.printStackTrace();
		} // VO recebendo DAO
	}

}
