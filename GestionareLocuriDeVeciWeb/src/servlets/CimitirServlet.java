package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.BusinessException;
import Domain.Cimitir;
import services.api.ServiceCimitire;
import services.impl.ServiceCimitireImpl;

/**
 * Servlet implementation class CimitirServlet
 */
@WebServlet("/CimitirServlet")
public class CimitirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceCimitire cimitirServlet = new ServiceCimitireImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CimitirServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession h = request.getSession();
		try {
			List<Cimitir> cimitire = cimitirServlet.getCimitire();
			h.setAttribute("listCimitire", cimitire);
			response.sendRedirect("jsp/Cimitir.jsp");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
