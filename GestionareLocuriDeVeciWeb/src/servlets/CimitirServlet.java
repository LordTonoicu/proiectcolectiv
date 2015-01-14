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
import exceptions.BusinessException;
import services.ServiceCimitire;
import services.ServiceCimitireImpl;

/**
 * Servlet implementation class CimitirServlet
 */
@WebServlet("/CimitirServlet")
public class CimitirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceCimitire cimitirService = new ServiceCimitireImpl();

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
		try{
			if(request.getParameter("adaugaCimitir")!=null)	{
				adaugaCimitir(request);
			}
			else if(request.getParameter("stergeCimitir")!=null){
				stergeCimitir(request);
			}
			else if(request.getParameter("updateCimitir")!=null){
				updateCimitir(request);
			}
			else if(request.getParameter("parcele")!=null){
				int idCimitir=Integer.parseInt(request.getParameter("idCimitir"));
				h.setAttribute("idCimitir", idCimitir);
				response.sendRedirect("ParcelaServlet");
				return;
			}
	
			List<Cimitir> cimitire = cimitirService.getCimitire();
			h.setAttribute("listCimitire", cimitire);
			response.sendRedirect("jsp/Cimitir.jsp");
			
			h.setAttribute("exceptie", "");
			
		}catch (BusinessException e){
			h.setAttribute("exceptie", e.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		
		}
	}
	private void updateCimitir(HttpServletRequest request) throws BusinessException {
		Cimitir c = new Cimitir();
		c.setIdCimitir(Integer.parseInt(request.getParameter("idCimitir")));
		c.setAdresa(request.getParameter("adresa"));
		c.setDenumire(request.getParameter("denumire"));
		cimitirService.actualizeazaCimitir(c,request.getRemoteHost());
		
	}

	private void adaugaCimitir(HttpServletRequest request) throws BusinessException
	{
		Cimitir c = new Cimitir();
		c.setAdresa(request.getParameter("Adresa"));
		c.setDenumire(request.getParameter("Denumire"));
		c.setNrParcele(0);
		c.setNrLocuri(0);
		cimitirService.adaugaCimitir(c,request.getRemoteHost());
	}
	private void stergeCimitir(HttpServletRequest request) throws BusinessException
	{
		String id = request.getParameter("idCimitir");
		Cimitir c = new Cimitir();
		c.setIdCimitir(Integer.parseInt(id));
		cimitirService.stergeCimitir(c,request.getRemoteHost());
	}
}
