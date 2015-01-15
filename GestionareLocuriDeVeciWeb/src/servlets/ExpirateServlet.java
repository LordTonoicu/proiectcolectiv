package servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import domain.Cimitir;
import domain.LocDeVeci;
import domain.Parcela;
import dto.ConcesionarDTO;
import dto.LocDeVeciDTO;
import dto.ParcelaDTO;
import exceptions.BusinessException;
import services.ServiceCimitire;
import services.ServiceCimitireImpl;
import services.ServiceConcesionari;
import services.ServiceConcesionariImpl;
import services.ServiceLocuriDeVeci;
import services.ServiceLocuriDeVeciImpl;
import services.ServiceParcele;
import services.ServiceParceleImpl;

/**
 * Servlet implementation class LocDeVeciServlet
 */
@WebServlet("/ExpirateServlet")
@MultipartConfig(maxFileSize = 16177215)
public class ExpirateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceLocuriDeVeci locDeVeciService = new ServiceLocuriDeVeciImpl();
	private ServiceCimitire cimitirService = new ServiceCimitireImpl();
	private ServiceParcele parcelaService = new ServiceParceleImpl();
	private ServiceConcesionari concesionariService = new ServiceConcesionariImpl();

	private InputStream inputStream = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExpirateServlet() {
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
			if (request.getParameter("download") != null)
				downloadPoza(request, response);

			
			List<LocDeVeciDTO> locuriDeVeciExpirate = locDeVeciService.getLocuriDeVeciExpirate();
					
			
			h.setAttribute("listLocuriDeVeciExpirate", locuriDeVeciExpirate);
			
			
			response.sendRedirect("jsp/locuriDeVeciExpirate.jsp");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void downloadPoza(HttpServletRequest request,
			HttpServletResponse response) throws IOException, BusinessException {

		int idLocDeVeci = Integer.parseInt(request.getParameter("idLocDeVeci"));
		LocDeVeci loc = locDeVeciService.getById(idLocDeVeci);
		byte[] poza = loc.getPoza();

		if (poza.length != 0) {
			ServletOutputStream outStream = response.getOutputStream();
			response.setContentType("jpg");
			response.setContentLength(poza.length);
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ "poza" + "\"");

			outStream.write(poza, 0, poza.length);
		}

	}

	private void deleteLocDeVeci(HttpServletRequest request)
			throws BusinessException, IllegalStateException, IOException,
			ServletException {

		String id = request.getParameter("idLocDeVeci");
		LocDeVeci loc = new LocDeVeci();
		loc.setIdLoc(Integer.parseInt(id));
		locDeVeciService.stergeLocDeVeci(loc, request.getRemoteHost());
	}

	private void updateLocDeVeci(HttpServletRequest request)
			throws BusinessException, IllegalStateException, IOException,
			ServletException {

		int idLocDeVeci = Integer.parseInt(request.getParameter("idLocDeVeci"));
		LocDeVeci loc = locDeVeciService.getById(idLocDeVeci);

		if (request.getParameter("esteMonument") != null) {
			loc.setMonument(true);
		} else
			loc.setMonument(false);
		
		loc.setSuprafata(Integer.parseInt(request.getParameter("suprafata")));
		loc.setNumar(Integer.parseInt(request.getParameter("numar")));
		loc.setIdCimitir((Integer) request.getSession().getAttribute(
				"idCimitir"));
		loc.setIdParcela((Integer) request.getSession().getAttribute(
				"idParcela"));
		Part filePart = request.getPart("poza");
		inputStream = filePart.getInputStream();
		if (filePart.getSize() != 0) {
			loc.setPoza(getBytes(inputStream));
		}

		locDeVeciService.actualizeazaLocDeVeci(loc, request.getRemoteHost());

	}

	private void adaugaLocDeVeci(HttpServletRequest request)
			throws BusinessException, IllegalStateException, IOException,
			ServletException {

		LocDeVeci locDeVeci = new LocDeVeci();
		HttpSession sesiune = request.getSession();
		locDeVeci.setSuprafata(Integer.parseInt(request
				.getParameter("suprafata")));
		locDeVeci.setIdCimitir((Integer) sesiune.getAttribute("idCimitir"));
		locDeVeci.setIdParcela((Integer) sesiune.getAttribute("idParcela"));
		locDeVeci.setNumar(Integer.parseInt(request.getParameter("numar")));
		if (request.getParameter("esteMonument") != null)
			locDeVeci.setMonument(true);
		else {
			locDeVeci.setMonument(false);
		}

		Part filePart = request.getPart("poza");
		inputStream = filePart.getInputStream();
		if (filePart.getSize() != 0) {
			locDeVeci.setPoza(getBytes(inputStream));
		} else {
			byte[] poza = { 0 };
			locDeVeci.setPoza(poza);
		}
		locDeVeciService.adaugaLocDeVeci(locDeVeci, request.getRemoteHost());

	}

	private static byte[] getBytes(InputStream is) throws IOException {

		int len = 0;
		int size = 1024;
		byte[] buf;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		buf = new byte[size];
		while ((len = is.read(buf, 0, size)) != -1)
			bos.write(buf, 0, len);
		buf = bos.toByteArray();

		return buf;
	}
}
