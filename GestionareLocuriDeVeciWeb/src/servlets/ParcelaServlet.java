package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import domain.Parcela;
import exceptions.BusinessException;
import services.ServiceParcele;
import services.ServiceParceleImpl;

/**
 * Servlet implementation class ParcelaServlet
 */
@WebServlet("/ParcelaServlet")
public class ParcelaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServiceParcele parcelaService = new ServiceParceleImpl();
    public ParcelaServlet() {
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
			List<Parcela> parcele = parcelaService.getParcele();
			h.setAttribute("listParcele", parcele);
			response.sendRedirect("jsp/Parcele.jsp");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
