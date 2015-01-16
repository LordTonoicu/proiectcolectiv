package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.registers.InregRegAnualDecedati;
import exceptions.BusinessException;
import services.ServiceRegistre;
import services.ServiceRegistreImpl;

/**
 * Servlet implementation class Table4Servlet
 */
@WebServlet("/Table4Servlet")
public class Table4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceRegistre serviceRegistre = new ServiceRegistreImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Table4Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ArrayList<InregRegAnualDecedati> registru =(ArrayList<InregRegAnualDecedati>) serviceRegistre.getRegAnualDecedati();
			request.getSession().setAttribute("registru4", registru);
			response.sendRedirect("jsp/tables4.jsp");
		}catch(BusinessException ex)
		{
			request.getSession().setAttribute("exceptie",ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}

}
