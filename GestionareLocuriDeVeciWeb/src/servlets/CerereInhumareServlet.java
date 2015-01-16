package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CerereInhumare;
import domain.ContractConcesiune;
import dto.CerereInhumareDTO;
import dto.ConcesionarDTO;
import dto.ContractConcesiuneDTO;
import exceptions.BusinessException;
import services.ServiceCereriInhumare;
import services.ServiceCereriInhumareImpl;
import services.ServiceConcesionari;
import services.ServiceConcesionariImpl;

/**
 * Servlet implementation class CerereInhumareServlet
 */
@WebServlet("/CerereInhumareServlet")
public class CerereInhumareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceCereriInhumare cereriInhumareService = new ServiceCereriInhumareImpl();
	private ServiceConcesionari concesionarService = new ServiceConcesionariImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CerereInhumareServlet() {
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
		try {
			if (request.getParameter("stergeCerere") != null)
				stergeCerere(request);
			else if(request.getParameter("updateCerere")!=null)
				updateCerere(request);
			else if(request.getParameter("adaugaCerere")!=null){
				adaugaCerere(request);
				response.sendRedirect("locuriDeVeciServlet");
				return;
			}
			
			List<CerereInhumareDTO> list = cereriInhumareService
					.getCereriInhumare();
			request.getSession().setAttribute("listCereri", list);

			List<ConcesionarDTO> listConcesionari = concesionarService
					.getConcesionari();
			request.getSession().setAttribute("listConcesionari",
					listConcesionari);

			response.sendRedirect("jsp/CereriInhumare.jsp");

		} catch (BusinessException e) {
			
			e.printStackTrace();
			request.getSession().setAttribute("exceptie", e.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}

	private void adaugaCerere(HttpServletRequest request) throws BusinessException {
		int nrCerere = Integer.parseInt(request.getParameter("nrCerere"));
		String cnpConcesionar = request.getParameter("cnpConcesionar");
		System.out.println("|"+cnpConcesionar+"|");
		String stadiuSolutionare = request.getParameter("stadiuSolutionare");
		String dataInregistrare  = request.getParameter("dataInregistrare");

		CerereInhumare cerereInhumare=new CerereInhumare(nrCerere, Date.valueOf(dataInregistrare), stadiuSolutionare, cnpConcesionar);		
		
		cereriInhumareService.adaugaCerereInhumare(cerereInhumare, request.getRemoteHost());	
	}

	private void updateCerere(HttpServletRequest request) throws BusinessException {
		int nrCerere = Integer.parseInt(request.getParameter("nrCerere"));
		String cnpConcesionar = request.getParameter("cnpConcesionar");
		String stadiuSolutionare = request.getParameter("stadiuSolutionare");
		String dataInregistrare  = request.getParameter("dataInregistrare");
		
		CerereInhumare cerereInhumare=new CerereInhumare(nrCerere, Date.valueOf(dataInregistrare), stadiuSolutionare, cnpConcesionar);		
		
		cereriInhumareService.actualizeazaCerereInhumare(cerereInhumare, request.getRemoteHost());	
	}

	private void stergeCerere(HttpServletRequest request)
			throws BusinessException {
		CerereInhumare cerereInhumare = new CerereInhumare();
		cerereInhumare.setNrCerere(Integer.parseInt(request
				.getParameter("nrCerere")));
		
		cereriInhumareService.stergeCerereInhumare(cerereInhumare, request.getRemoteHost());
	}

}
