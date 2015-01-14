package servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import domain.Concesionar;
import domain.ContractConcesiune;
import domain.DatePersonale;
import domain.LocDeVeci;
import dto.ConcesionarDTO;
import dto.ContractConcesiuneDTO;
import exceptions.BusinessException;
import exceptions.ValidatorException;
import services.ServiceConcesionari;
import services.ServiceConcesionariImpl;
import services.ServiceContracteConcesiune;
import services.ServiceContracteConcesiuneImpl;
import services.util.UtilInregistrareJurnal;
import validators.CNPValidator;
import validators.ContractConcesiuneValidator;

/**
 * Servlet implementation class ConcesionarServlet
 */
@WebServlet("/ContractServlet")
public class ContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceContracteConcesiune contractService = new ServiceContracteConcesiuneImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContractServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			
			if(request.getParameter("updateContract")!=null)
			{
				String nrContract = request.getParameter("nrContract");
				String cnpConcesionar1 = request.getParameter("cnpConcesionar1");
				String cnpConcesionar2 = request.getParameter("cnpConcesionar2");
				String  dataEliberare  = request.getParameter("dataEliberare");
//				
//				ContractConcesiune c = new ContractConcesiune(Integer.parseInt(nrContract),Date.valueOf(dataEliberare),cnpConcesionar1,cnpConcesionar2);
//				DatePersonale d = new DatePersonale(cnp,nume,prenume);
//				ConcesionarDTO cdto = new ConcesionarDTO(c,d);
//				concesionarService.actualizeazaConcesionar(cdto,request.getRemoteHost());
			}
			else if(request.getParameter("stergeContract")!=null)
			{
                      deleteContract(request);
			}
			else if(request.getParameter("adaugaContract")!=null){
				adaugaContract(request);
			}
			
			List<ContractConcesiuneDTO> list = contractService.getContracteConcesiune();
			System.out.println(list.size());

			request.getSession().setAttribute("listContracte", list);
			response.sendRedirect("jsp/Contracte.jsp");
		}
		catch(BusinessException ex)
		{
			System.out.println(ex.getMessage());
			request.getSession().setAttribute("exceptie",ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}
	private void adaugaContract(HttpServletRequest request) throws BusinessException, IllegalStateException, IOException,
	ServletException{
//		LocDeVeci locDeVeci = new LocDeVeci();
//		HttpSession sesiune = request.getSession();
//		locDeVeci.setSuprafata(Integer.parseInt(request
//				.getParameter("suprafata")));
//		locDeVeci.setIdCimitir((Integer) sesiune.getAttribute("idCimitir"));
//		locDeVeci.setIdParcela((Integer) sesiune.getAttribute("idParcela"));
//		locDeVeci.setNumar(Integer.parseInt(request.getParameter("numar")));
//		if (request.getParameter("esteMonument") != null)
//			locDeVeci.setMonument(true);
//		else {
//			locDeVeci.setMonument(false);
//		}
//
//		Part filePart = request.getPart("poza");
//		inputStream = filePart.getInputStream();
//		if (filePart.getSize() != 0) {
//			locDeVeci.setPoza(getBytes(inputStream));
//		} else {
//			byte[] poza = { 0 };
//			locDeVeci.setPoza(poza);
//		}
//		locDeVeciService.adaugaLocDeVeci(locDeVeci, request.getRemoteHost());
		
		
	}

	private void deleteContract(HttpServletRequest request)
			throws BusinessException, IllegalStateException, IOException,
			ServletException {

		String nr = request.getParameter("nrContract");
		ContractConcesiune contract = new ContractConcesiune();
		contract.setNrContract(Integer.valueOf(nr)); 
		contractService.stergeContractConcesiune(contract,request.getRemoteHost());
	}


}
