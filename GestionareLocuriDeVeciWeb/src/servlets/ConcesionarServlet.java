package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Concesionar;
import domain.DatePersonale;
import dto.ConcesionarDTO;
import exceptions.BusinessException;
import services.ServiceConcesionari;
import services.ServiceConcesionariImpl;

/**
 * Servlet implementation class ConcesionarServlet
 */
@WebServlet("/ConcesionarServlet")
public class ConcesionarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceConcesionari concesionarService = new ServiceConcesionariImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConcesionarServlet() {
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
			if (request.getParameter("adaugaConcesionar") != null) {
				adaugaConcesionar(request);
			} else if (request.getParameter("updateConcesionar") != null) {
				updateConcesionar(request);
			} else if (request.getParameter("stergeConcesionar") != null) {
				stergeConcesionar(request);
			}
			List<ConcesionarDTO> list = concesionarService.getConcesionari();

			request.getSession().setAttribute("listConcesionari", list);
			response.sendRedirect("jsp/Concesionar.jsp");
		} catch (BusinessException ex) {
			System.out.println(ex.getMessage());
			request.getSession().setAttribute("exceptie", ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}

	private void adaugaConcesionar(HttpServletRequest request) throws BusinessException {
		String nume = request.getParameter("nume");
		String prenume = request.getParameter("prenume");
		String domiciliu = request.getParameter("domiciliu");
		String cnp = request.getParameter("cnp");
		String nrChitanta = request.getParameter("nrChitanta");
		Concesionar c = new Concesionar(domiciliu,
				Integer.parseInt(nrChitanta), cnp);
		DatePersonale d = new DatePersonale(cnp, nume, prenume);
		ConcesionarDTO cdto = new ConcesionarDTO(c, d);
		concesionarService.adaugaConcesionar(cdto,
				request.getRemoteHost());

	}

	private void updateConcesionar(HttpServletRequest request)
			throws BusinessException {
		String idConcesionar = request.getParameter("idConcesionar");
		String nume = request.getParameter("nume");
		String prenume = request.getParameter("prenume");
		String domiciliu = request.getParameter("domiciliu");
		String cnp = request.getParameter("cnp");
		String nrChitanta = request.getParameter("nrChitanta");
		Concesionar c = new Concesionar(Integer.parseInt(idConcesionar),
				domiciliu, Integer.parseInt(nrChitanta), cnp);
		DatePersonale d = new DatePersonale(cnp, nume, prenume);
		ConcesionarDTO cdto = new ConcesionarDTO(c, d);
		concesionarService.actualizeazaConcesionar(cdto,
				request.getRemoteHost());

	}

	private void stergeConcesionar(HttpServletRequest request)
			throws BusinessException {
		String idConcesionar = request.getParameter("idConcesionar");
		System.out.println(idConcesionar);
		String nume = request.getParameter("nume");
		String prenume = request.getParameter("prenume");
		String domiciliu = request.getParameter("domiciliu");
		String cnp = request.getParameter("cnp");
		String nrChitanta = request.getParameter("nrChitanta");
		Concesionar c = new Concesionar(Integer.parseInt(idConcesionar),
				domiciliu, Integer.parseInt(nrChitanta), cnp);
		DatePersonale d = new DatePersonale(cnp, nume, prenume);
		ConcesionarDTO cdto = new ConcesionarDTO(c, d);
		concesionarService.stergeConcesionar(cdto, request.getRemoteHost());

	}

}
