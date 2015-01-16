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
import domain.registers.InregRegDecedatiFaraApartinatori;
import exceptions.BusinessException;

/**
 * Servlet implementation class Table5Servlet
 */
@WebServlet("/Table5Servlet")
public class Table5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceRegistre serviceRegistre = new ServiceRegistreImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table5Servlet() {
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
		try
		{
			ArrayList<InregRegDecedatiFaraApartinatori> registru =(ArrayList<InregRegDecedatiFaraApartinatori>) serviceRegistre.getRegAnualDecedatiFaraApartinatori();
			request.getSession().setAttribute("registru5", registru);
			response.sendRedirect("jsp/tables5.jsp");
		}
		catch(BusinessException ex)
		{
			request.getSession().setAttribute("exceptie",ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}

}
