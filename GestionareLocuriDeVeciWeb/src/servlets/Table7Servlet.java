package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ServiceRegistre;
import services.ServiceRegistreImpl;
import domain.registers.InregRegAnualDeProgrInmormantari;
import domain.registers.InregRegContracteConcesiune;
import exceptions.BusinessException;

/**
 * Servlet implementation class Table7Servlet
 */
@WebServlet("/Table7Servlet")
public class Table7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceRegistre serviceRegistre = new ServiceRegistreImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table7Servlet() {
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
		try
		{
			ArrayList<InregRegContracteConcesiune> registru =(ArrayList<InregRegContracteConcesiune>) serviceRegistre.getRegContracteConcesiune();
			request.getSession().setAttribute("registru7", registru);
			response.sendRedirect("jsp/tables7.jsp");
		}
		catch(BusinessException ex)
		{
			request.getSession().setAttribute("exceptie",ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}

}
