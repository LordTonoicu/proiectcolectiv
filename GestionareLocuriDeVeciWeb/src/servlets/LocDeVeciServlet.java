package servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
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
import dto.ParcelaDTO;
import exceptions.BusinessException;
import services.ServiceCimitire;
import services.ServiceCimitireImpl;
import services.ServiceLocuriDeVeci;
import services.ServiceLocuriDeVeciImpl;
import services.ServiceParcele;
import services.ServiceParceleImpl;

/**
 * Servlet implementation class LocDeVeciServlet
 */
@WebServlet("/locuriDeVeciServlet")
@MultipartConfig(maxFileSize = 16177215)
public class LocDeVeciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceLocuriDeVeci locDeVeciService = new ServiceLocuriDeVeciImpl();
	private ServiceCimitire cimitirService = new ServiceCimitireImpl();
	private ServiceParcele parcelaService = new ServiceParceleImpl();
	
	private InputStream inputStream = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocDeVeciServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession h = request.getSession();
	try {
		if (request.getParameter("adaugaLocDeVeci") != null)
				adaugaLocDeVeci(request);
	}catch(BusinessException e){
		e.printStackTrace();
	}
	try {
			List<ParcelaDTO> parcele=parcelaService.getParcele();
			List<Cimitir> cimitire=cimitirService.getCimitire();
			List<LocDeVeci> locuriDeVeci=locDeVeciService.getLocuriDeVeci();
			h.setAttribute("listLocuriDeVeci", locuriDeVeci);
			h.setAttribute("listParcele", parcele);
			h.setAttribute("listCimitire", cimitire);
			response.sendRedirect("jsp/locuriDeVeci.jsp");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

	private void adaugaLocDeVeci(HttpServletRequest request) throws BusinessException, IllegalStateException, IOException, ServletException {
		LocDeVeci locDeVeci=new LocDeVeci();
		locDeVeci.setIdCimitir(Integer.parseInt(request.getParameter("cimitire")));
		locDeVeci.setIdParcela(Integer.parseInt(request.getParameter("parcele")));
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
		}
		locDeVeciService.adaugaLocDeVeci(locDeVeci);

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
