package servlets;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Cimitir;
import domain.LocDeVeci;
import dto.DecedatDTO;
import exceptions.BusinessException;
import services.ServiceDecedati;
import services.ServiceDecedatiImpl;
import services.ServiceLocuriDeVeci;
import services.ServiceLocuriDeVeciImpl;

/**
 * Servlet implementation class DecedatServlet
 */
@WebServlet("/DecedatServlet")
public class DecedatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceDecedati decedatService = new ServiceDecedatiImpl();
	ServiceLocuriDeVeci locuriDeVeciService = new ServiceLocuriDeVeciImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DecedatServlet() {
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
			if (request.getParameter("adaugaDecedat") != null) {
				adaugaDecedat(request);
				response.sendRedirect("locuriDeVeciServlet");
				return;
			} else if (request.getParameter("stergeDecedat") != null) {
				stergeDecedat(request);
			} else if (request.getParameter("updateDecedat") != null) {
				updateDecedat(request);
			}

			List<LocDeVeci> locuriDeVeci = locuriDeVeciService
					.getLocuriDeVeci();
			List<DecedatDTO> decedati = decedatService.getDecedati();
			h.setAttribute("listLocuriDeVeci", locuriDeVeci);
			h.setAttribute("listDecedati", decedati);
			response.sendRedirect("jsp/Decedat.jsp");
		} catch (BusinessException e) {
			// TODO redirect exception handler
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	private void updateDecedat(HttpServletRequest request)
			throws BusinessException {
		DecedatDTO dec = new DecedatDTO();

		dec.getDecedat().setCnpDecedat(
				(String) request.getParameter("CnpDecedat"));
		dec.getDecedat().setDataInmormantare(
				Date.valueOf(request.getParameter("DateInmormantareDecedat")));
		dec.getDecedat().setNrAdeverintaInhumare(
				Integer.valueOf(request
						.getParameter("NrAdeverintaInhumareDecedat")));
		dec.getDecedat().setIdLocDeVeci(
				Integer.valueOf(request.getParameter("idLocDeVeci")));
		if (request.getParameter("ePersonalitate") != null) {
			System.out.println("E");
			dec.getDecedat().setePersonalitate(true);
		} else
			dec.getDecedat().setePersonalitate(false);
		
		dec.getDatePersonale().setNume(request.getParameter("NumeDecedat"));
		dec.getDatePersonale().setPrenume(
				request.getParameter("PrenumeDecedat"));
		dec.getDatePersonale().setCnp(request.getParameter("CnpDecedat"));
		decedatService.actualizeazaDecedat(dec, request.getRemoteHost());

	}

	private void adaugaDecedat(HttpServletRequest request)
			throws BusinessException {

		DecedatDTO dec = new DecedatDTO();

		dec.getDecedat().setCnpDecedat(
				(String) request.getParameter("CnpDecedat"));
		dec.getDecedat().setDataInmormantare(
				Date.valueOf(request.getParameter("DateInmormantareDecedat")));
		dec.getDecedat().setNrAdeverintaInhumare(
				Integer.valueOf(request
						.getParameter("NrAdeverintaInhumareDecedat")));
		dec.getDecedat().setIdLocDeVeci(
				Integer.valueOf(request.getParameter("idLocDeVeci")));

		if (request.getParameter("ePersonalitate") != null) {
			dec.getDecedat().setePersonalitate(true);
		} else
			dec.getDecedat().setePersonalitate(false);

		dec.getDatePersonale().setNume(request.getParameter("NumeDecedat"));
		dec.getDatePersonale().setPrenume(
				request.getParameter("PrenumeDecedat"));
		dec.getDatePersonale().setCnp(request.getParameter("CnpDecedat"));
		

		decedatService.inscrieDecedat(dec, request.getRemoteHost());

	}

	private void stergeDecedat(HttpServletRequest request)
			throws BusinessException {
		String id = request.getParameter("idDecedat");
		String cnp = request.getParameter("CnpDecedat");
		DecedatDTO dec = new DecedatDTO();
		dec.getDecedat().setIdDecedat(Integer.parseInt(id));
		dec.getDatePersonale().setCnp(cnp);
		decedatService.stergeDecedat(dec, request.getRemoteHost());

	}

}
