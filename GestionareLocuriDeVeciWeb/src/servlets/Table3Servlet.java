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
import domain.registers.InregRegDeMorminte;
import domain.registers.InregRegMorminteMonFunerareVal;
import exceptions.BusinessException;

/**
 * Servlet implementation class Table3Servlet
 */
@WebServlet("/Table3Servlet")
public class Table3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceRegistre serviceRegistre = new ServiceRegistreImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table3Servlet() {
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
			ArrayList<InregRegMorminteMonFunerareVal> registru = (ArrayList<InregRegMorminteMonFunerareVal>) serviceRegistre.getRegDeMorminteMonFunerare();
			request.getSession().setAttribute("registru3",registru);
			response.sendRedirect("jsp/tables3.jsp");
		}catch(BusinessException ex)
		{
			request.getSession().setAttribute("exceptie",ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}

	}

}
