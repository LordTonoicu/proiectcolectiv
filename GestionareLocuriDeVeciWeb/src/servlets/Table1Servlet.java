package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ServiceRegistre;
import services.ServiceRegistreImpl;
import domain.registers.InregRegAnualDeProgrInmormantari;
import exceptions.BusinessException;
/**
 * Servlet implementation class Table1Servlet
 */
@WebServlet("/Table1Servlet")
public class Table1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ServiceRegistre serviceRegistre = new ServiceRegistreImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			ArrayList<InregRegAnualDeProgrInmormantari> registru =(ArrayList<InregRegAnualDeProgrInmormantari>) serviceRegistre.getRegAnualDeProgramareAInmormantarilor();
			request.getSession().setAttribute("registru1", registru);
			response.sendRedirect("jsp/tables1.jsp");
		}
		catch(BusinessException ex)
		{
			request.getSession().setAttribute("eroare",ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}

}
