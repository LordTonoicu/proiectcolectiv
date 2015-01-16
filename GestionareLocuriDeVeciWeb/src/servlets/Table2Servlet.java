package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.registers.InregRegDeMorminte;
import services.ServiceRegistre;
import services.ServiceRegistreImpl;
import exceptions.BusinessException;

/**
 * Servlet implementation class Table2Servlet
 */
@WebServlet("/Table2Servlet")
public class Table2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceRegistre serviceRegistre = new ServiceRegistreImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table2Servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ArrayList<InregRegDeMorminte> registru = (ArrayList<InregRegDeMorminte>) serviceRegistre.getRegDeMorminte();
			request.getSession().setAttribute("registru2",registru);
			response.sendRedirect("jsp/tables2.jsp");
		}catch(BusinessException ex)
		{
			request.getSession().setAttribute("exceptie",ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}

}
