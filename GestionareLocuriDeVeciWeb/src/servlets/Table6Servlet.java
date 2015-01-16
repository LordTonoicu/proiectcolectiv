package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.registers.InregRegAnualDeProgrInmormantari;
import domain.registers.InregRegCereriInhumare;
import exceptions.BusinessException;
import services.ServiceRegistre;
import services.ServiceRegistreImpl;

/**
 * Servlet implementation class Table6Servlet
 */
@WebServlet("/Table6Servlet")
public class Table6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceRegistre serviceRegistre = new ServiceRegistreImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table6Servlet() {
        super();
        
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
			ArrayList<InregRegCereriInhumare> registru =(ArrayList<InregRegCereriInhumare>) serviceRegistre.getRegCereriInhumare();
			request.getSession().setAttribute("registru6", registru);
			response.sendRedirect("jsp/tables6.jsp");
		}
		catch(BusinessException ex)
		{
			request.getSession().setAttribute("exceptie",ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}

}
