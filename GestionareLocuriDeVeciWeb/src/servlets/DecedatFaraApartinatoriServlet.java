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
import domain.DecedatFaraApartinatori;
import domain.LocDeVeci;
import dto.DecedatDTO;
import dto.DecedatFaraApartinatoriDTO;
import exceptions.BusinessException;
import services.ServiceDecedati;
import services.ServiceDecedatiFaraApartinatori;
import services.ServiceDecedatiFaraApartinatoriImpl;
import services.ServiceDecedatiImpl;
import services.ServiceLocuriDeVeci;
import services.ServiceLocuriDeVeciImpl;

/**
 * Servlet implementation class DecedatServlet
 */
@WebServlet("/DecedatFaraApartinatoriServlet")
public class DecedatFaraApartinatoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceDecedatiFaraApartinatori decedatService = new ServiceDecedatiFaraApartinatoriImpl();
	ServiceLocuriDeVeci locuriDeVeciService = new ServiceLocuriDeVeciImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DecedatFaraApartinatoriServlet() {
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
			if (request.getParameter("adaugaDecedatFaraApartinator") != null) {
				adaugaDecedat(request);
				response.sendRedirect("locuriDeVeciServlet");
				return;
			} else if (request.getParameter("stergeDecedatFaraApartinator") != null) {
				stergeDecedat(request);
			} else if (request.getParameter("updateDecedatFaraApartinator") != null) {
				updateDecedat(request);
			}

			List<LocDeVeci> locuriDeVeci = locuriDeVeciService
					.getLocuriDeVeci();
			List<DecedatFaraApartinatoriDTO> decedati = decedatService.getDecedatiFaraApartinatori();
			h.setAttribute("listLocuriDeVeci", locuriDeVeci);
			h.setAttribute("listDecedatiFaraApartinatori", decedati);
			response.sendRedirect("jsp/DecedatFaraApartinatori.jsp");
		} catch (BusinessException e) {
			h.setAttribute("exceptie", e.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	private void updateDecedat(HttpServletRequest request)
			throws BusinessException {
		DecedatFaraApartinatoriDTO dec = new DecedatFaraApartinatoriDTO();

		dec.getDecedat().setCnpDecedat(
				(String) request.getParameter("CnpDecedat"));
		dec.getDecedat().setDataInmormantare(
				Date.valueOf(request.getParameter("DateInmormantareDecedat")));
		dec.getDecedat().setNrAdeverintaInhumare(
				Integer.valueOf(request
						.getParameter("NrAdeverintaInhumareDecedat")));
		dec.getDecedat().setIdLocDeVeci(
				Integer.valueOf(request.getParameter("idLocDeVeci")));
		dec.getDecedat().setReligie(request.getParameter("Religie"));
		dec.getDecedat().setNrAdeverintaAsistenta(Integer.valueOf(request.getParameter("NrAdeverintaAsistenta")));
		
		dec.getDatePersonale().setNume(request.getParameter("NumeDecedat"));
		dec.getDatePersonale().setPrenume(
				request.getParameter("PrenumeDecedat"));
		dec.getDatePersonale().setCnp(request.getParameter("CnpDecedat"));
		decedatService.actualizeazaDecedatFaraApartinator(dec, request.getRemoteHost());

	}

	private void adaugaDecedat(HttpServletRequest request)
			throws BusinessException {

		DecedatFaraApartinatoriDTO dec = new DecedatFaraApartinatoriDTO();

		dec.getDecedat().setCnpDecedat(
				(String) request.getParameter("CnpDecedat"));
		dec.getDecedat().setDataInmormantare(
				Date.valueOf(request.getParameter("DateInmormantareDecedat")));
		dec.getDecedat().setNrAdeverintaInhumare(
				Integer.valueOf(request
						.getParameter("NrAdeverintaInhumareDecedat")));
		dec.getDecedat().setIdLocDeVeci(
				Integer.valueOf(request.getParameter("idLocDeVeci")));
		dec.getDecedat().setReligie(request.getParameter("Religie"));

		dec.getDecedat().setNrAdeverintaAsistenta(Integer.valueOf(request.getParameter("nrAdeverintaAsistenta")));

		dec.getDatePersonale().setNume(request.getParameter("NumeDecedat"));
		dec.getDatePersonale().setPrenume(
				request.getParameter("PrenumeDecedat"));
		dec.getDatePersonale().setCnp(request.getParameter("CnpDecedat"));
		

		decedatService.inscrieDecedatFaraApartinator(dec, request.getRemoteHost());

	}

	private void stergeDecedat(HttpServletRequest request)
			throws BusinessException {
		String id = request.getParameter("idDecedat");
		String cnp = request.getParameter("CnpDecedat");
		DecedatFaraApartinatoriDTO dec = new DecedatFaraApartinatoriDTO();
		dec.getDecedat().setIdDecedat(Integer.parseInt(id));
		dec.getDatePersonale().setCnp(cnp);
		decedatService.stergeDecedatFaraApartinator(dec, request.getRemoteHost());

	}

}
