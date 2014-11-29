package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Cimitir;
import domain.Parcela;
import exceptions.BusinessException;
import services.ServiceCimitire;
import services.ServiceCimitireImpl;
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
	ServiceCimitire cimitirService = new ServiceCimitireImpl();

	public ParcelaServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		if (request.getParameter("adaugaParcela") != null)
			try {
				adaugaParcela(request);
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			List<Parcela> parcele = parcelaService.getParcele();
			List<Cimitir> cimitire = cimitirService.getCimitire();
			h.setAttribute("listCimitire", cimitire);
			h.setAttribute("listParcele", parcele);
			response.sendRedirect("jsp/Parcele.jsp");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void adaugaParcela(HttpServletRequest request)
			throws BusinessException {
		Parcela parcela = new Parcela();
		parcela.setDenumire(request.getParameter("denumire"));
		parcela.setIdCimitir(Integer.parseInt(request.getParameter("cimitire")));
		if (request.getParameter("areMonument") != null)
			parcela.setHasMonument(true);
		else {
			parcela.setHasMonument(false);
		}
		parcelaService.adaugaParcela(parcela);

	}

}
