package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.DecedatDTO;
import exceptions.BusinessException;
import services.ServiceDecedati;
import services.ServiceDecedatiImpl;

/**
 * Servlet implementation class DecedatServlet
 */
@WebServlet("/DecedatServlet")
public class DecedatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServiceDecedati decedatService = new ServiceDecedatiImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecedatServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		HttpSession h = request.getSession();
		try {
			List<DecedatDTO> decedati = decedatService.getDecedati();
			
			h.setAttribute("listDecedati", decedati);
			response.sendRedirect("jsp/Decedat.jsp");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
