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
import services.ServiceLocuriDeVeci;
import services.ServiceLocuriDeVeciImpl;
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
	ServiceConcesionari  concesionarService  = new ServiceConcesionariImpl();
	ServiceLocuriDeVeci locuriDeVeciService = new ServiceLocuriDeVeciImpl();

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
				updateContract(request);
			}
			else if(request.getParameter("stergeContract")!=null)
			{
                      deleteContract(request);
			}
			else if(request.getParameter("adaugaContract")!=null){
				adaugaContract(request);
				response.sendRedirect("locuriDeVeciServlet");
				return;
				
			}
			
			List<ContractConcesiuneDTO> list = contractService.getContracteConcesiune();
			List<ConcesionarDTO> listConcesionari = concesionarService.getConcesionari();
		

			request.getSession().setAttribute("listContracte", list);
			request.getSession().setAttribute("listConcesionari",listConcesionari);
			response.sendRedirect("jsp/Contracte.jsp");
		}
		catch(BusinessException ex)
		{
			System.out.println(ex.getMessage());
			request.getSession().setAttribute("exceptie",ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}
	private void updateContract(HttpServletRequest request) throws BusinessException {
		
		String nrContract = request.getParameter("nrContract");
		String cnpConcesionar1 = request.getParameter("cnpConcesionar1");
		String cnpConcesionar2 = request.getParameter("cnpConcesionar2");
		String  dataEliberare  = request.getParameter("dataEliberare");
		
		ContractConcesiune c = new ContractConcesiune(Integer.parseInt(nrContract),Date.valueOf(dataEliberare),cnpConcesionar1,cnpConcesionar2);
		
		contractService.actualizeazaContractConcesiune(c, request.getRemoteHost());
		
	}

	private void adaugaContract(HttpServletRequest request) throws BusinessException, IllegalStateException, IOException,
	ServletException{
		ContractConcesiune contractConcesiune = new ContractConcesiune();

		contractConcesiune.setCnpConcesionar1(request.getParameter("cnpConcesionar1"));
		
		contractConcesiune.setCnpConcesionar2(request.getParameter("cnpConcesionar2"));
	
		contractConcesiune.setDataEliberare(Date.valueOf(request.getParameter("dataEliberare")));
		contractConcesiune.setNrContract(Integer.valueOf(request.getParameter("nrContract")));
		contractService.adaugaContractConcesiune(contractConcesiune,request.getRemoteHost());
	    int id = Integer.valueOf(request.getParameter("idLocDeVeci"));
	    LocDeVeci loc = locuriDeVeciService.getById(id);
	    loc.setNrContractConcesionare(contractConcesiune.getNrContract());
		locuriDeVeciService.actualizeazaLocDeVeci(loc,request.getRemoteHost());
		
		
		
	}

	private void deleteContract(HttpServletRequest request)
			throws BusinessException, IllegalStateException, IOException,
			ServletException {

		String nr = request.getParameter("nrContract");
		ContractConcesiune contract = new ContractConcesiune();
		contract.setNrContract(Integer.valueOf(nr)); 
		contractService.stergeContractConcesiune(contract,request.getRemoteHost());
		locuriDeVeciService.deleteContractConcesiune(contract.getNrContract(),request.getRemoteHost());
	}


}
