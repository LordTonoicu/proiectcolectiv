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
import dto.LocDeVeciDTO;
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
		System.out.println("servlet");
		if (request.getParameter("adaugaLocDeVeci") != null)
				adaugaLocDeVeci(request);
		if (request.getParameter("stergeLocDeVeci")!=null){
			System.out.println("del");
			    deleteLocDeVeci(request);
		}
		if (request.getParameter("updateLocDeVeci")!=null){
			System.out.println("del");
			    deleteLocDeVeci(request);
		}
		
		
			
	}catch(BusinessException e){
		e.printStackTrace();
	}
	try {
		    int idParcela = (Integer)h.getAttribute("idParcela");
		    System.out.println(idParcela);
		    int idCimitir = (Integer)h.getAttribute("idCimitir");
			//List<ParcelaDTO> parcele=parcelaService.getParceleByIdCimitir(idCimitir);
			List<LocDeVeciDTO> locuriDeVeci=locDeVeciService.getLocuriDeVeciByIdParcela(idParcela);
			h.setAttribute("listLocuriDeVeci", locuriDeVeci);
//			h.setAttribute("listParcele", parcele);
//			h.setAttribute("listCimitire", cimitire);
			response.sendRedirect("jsp/locuriDeVeci.jsp");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
   private void deleteLocDeVeci(HttpServletRequest request ) throws BusinessException, IllegalStateException, IOException, ServletException {
       
	   String id = request.getParameter("idLocDeVeci");
	   System.out.println("myId"+id);
		LocDeVeci loc = new LocDeVeci();
		loc.setIdLoc(Integer.parseInt(id));
		locDeVeciService.stergeLocDeVeci(loc,request.getRemoteHost());
   }
   
	private void adaugaLocDeVeci(HttpServletRequest request) throws BusinessException, IllegalStateException, IOException, ServletException {
		
		LocDeVeci locDeVeci=new LocDeVeci();
		HttpSession sesiune = request.getSession();
		locDeVeci.setSuprafata(Integer.parseInt(request.getParameter("suprafata")));
		locDeVeci.setIdCimitir((Integer)sesiune.getAttribute("idCimitir"));
		locDeVeci.setIdParcela((Integer)sesiune.getAttribute("idParcela"));
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
		locDeVeciService.adaugaLocDeVeci(locDeVeci,request.getRemoteHost());
		

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
