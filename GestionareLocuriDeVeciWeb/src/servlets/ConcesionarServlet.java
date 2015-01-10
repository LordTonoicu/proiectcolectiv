package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ServiceConcesionari;
import services.ServiceConcesionariImpl;

/**
 * Servlet implementation class ConcesionarServlet
 */
@WebServlet("/ConcesionarServlet")
public class ConcesionarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServiceConcesionari concesionarService = new ServiceConcesionariImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConcesionarServlet() {
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
		// TODO Auto-generated method stub
	}

}
