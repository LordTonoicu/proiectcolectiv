package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Cimitir;
import domain.Parcela;
import dto.ParcelaDTO;
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

		try {
			if (request.getParameter("adaugaParcela") != null)
				adaugaParcela(request);
			else if(request.getParameter("stergeParcela")!=null)
				stergeParcela(request);
			else if(request.getParameter("getInfoParcela")!=null){
				Parcela parcela = null;
				parcela = getInfoParcela(request);
				h.setAttribute("parcela",parcela);
				openNewWindow(request,response,"updateParcela.jsp");
				return;
			}
		} catch (BusinessException e1) {
			// TODO redirect exception handler
			e1.printStackTrace();
		}
		try {
			List<ParcelaDTO> parcele = parcelaService.getParcele();
			List<Cimitir> cimitire = cimitirService.getCimitire();
			h.setAttribute("listCimitire", cimitire);
			h.setAttribute("listParcele", parcele);
			response.sendRedirect("jsp/Parcele.jsp");
		} catch (BusinessException e) {
			// TODO redirect to exception handler
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
	private void stergeParcela(HttpServletRequest request)
			throws BusinessException {
		String id = request.getParameter("idParcela");
		Parcela p = new Parcela();
		p.setIdParcela(Integer.parseInt(id));
		parcelaService.stergeParcela(p);
	}
	private Parcela getInfoParcela(HttpServletRequest request)
			throws BusinessException {
		String id = request.getParameter("idParcela");
		String denumire = request.getParameter("DenumireParcela");
		String cimitir = request.getParameter("idCimitirParcela");
		String areMonument = request.getParameter("hasMonumentParcela");
		String nrLocuri = request.getParameter("NrLocuriParcela");

		Parcela p = new Parcela();
		p.setIdParcela(Integer.parseInt(id));
		p.setDenumire(denumire);
		p.setIdCimitir(Integer.parseInt(cimitir));
		p.setHasMonument(Boolean.valueOf(areMonument));
		p.setNrLocuri(Integer.valueOf(nrLocuri));

		return p;

	}
	void openNewWindow(HttpServletRequest request,HttpServletResponse response,String jsp){
		try{
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("window.open(jsp/"+jsp+",'popUpWindow','height=700,width=400,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no,status=yes');");  
			out.println("</script>"); 
			response.sendRedirect("jsp/"+jsp);
		}
		catch (Exception e){
			
		}
	}

}
