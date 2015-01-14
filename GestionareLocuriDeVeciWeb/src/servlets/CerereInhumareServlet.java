package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CerereInhumare;
import dto.CerereInhumareDTO;
import dto.ContractConcesiuneDTO;
import exceptions.BusinessException;
import services.ServiceCereriInhumare;
import services.ServiceCereriInhumareImpl;

/**
 * Servlet implementation class CerereInhumareServlet
 */
@WebServlet("/CerereInhumareServlet")
public class CerereInhumareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceCereriInhumare cereriInhumareService = new ServiceCereriInhumareImpl();

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
			if(request.getParameter("stergeCerere")!=null)
				stergeCerere(request);
			List<CerereInhumareDTO> list = cereriInhumareService
					.getCereriInhumare();

			request.getSession().setAttribute("listCereri", list);
			response.sendRedirect("jsp/CereriInhumare.jsp");

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void stergeCerere(HttpServletRequest request) throws BusinessException {
		CerereInhumare cerereInhumare=new CerereInhumare();
		cerereInhumare.setNrCerere(Integer.parseInt(request.getParameter("nrCerere")));
		String user=request.getRemoteHost();
		cereriInhumareService.stergeCerereInhumare(cerereInhumare, user);
		
	}

}
