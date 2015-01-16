package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import domain.registers.InregRegAnualDeProgrInmormantari;
import domain.registers.InregRegAnualDecedati;
import exceptions.BusinessException;
import services.ServiceRegistre;
import services.ServiceRegistreImpl;

/**
 * Servlet implementation class Table4Servlet
 */
@WebServlet("/Table4Servlet")
public class Table4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceRegistre serviceRegistre = new ServiceRegistreImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Table4Servlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ArrayList<InregRegAnualDecedati> registru =(ArrayList<InregRegAnualDecedati>) serviceRegistre.getRegAnualDecedati();
			if(request.getParameter("exportExcel")!=null){
				exportExcel(request,response,registru);
				return;
			}
			request.getSession().setAttribute("registru4", registru);
			response.sendRedirect("jsp/tables4.jsp");
		}catch(BusinessException ex)
		{
			request.getSession().setAttribute("exceptie",ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}
	
	private void exportExcel(HttpServletRequest request,
			HttpServletResponse response,
			ArrayList<InregRegAnualDecedati> registru) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition",
				"attachment; filename=registru4.xls");
		WritableWorkbook workbook = Workbook.createWorkbook(response
				.getOutputStream());
		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
		try {
			WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
			cellFont.setBoldStyle(WritableFont.BOLD);

			WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
			
			sheet.addCell(new Label(0, 0, "Nume",cellFormat));
			sheet.addCell(new Label(1, 0, "Prenume",cellFormat));
			sheet.addCell(new Label(2, 0, "Cimitir",cellFormat));
			sheet.addCell(new Label(3, 0, "Parcela",cellFormat));
			sheet.addCell(new Label(4, 0, "Nr Mormant",cellFormat));
			sheet.addCell(new Label(5, 0, "Data inmormantarii",cellFormat));
			for (int i = 1; i < registru.size() + 1; i++) {
				sheet.addCell(new Label(0, i, registru.get(i-1).getNume()));
				sheet.addCell(new Label(1, i, registru.get(i-1).getPrenume()));
				sheet.addCell(new Label(2, i, registru.get(i-1).getCimitir()));
				sheet.addCell(new Label(3, i, registru.get(i - 1).getParcela()));
				sheet.addCell(new Label(4, i, String.valueOf(registru.get(i - 1).getNrMormant())));
				sheet.addCell(new Label(5, i, String.valueOf(registru.get(i - 1).getDataInmormantare())));
			}

			workbook.write();
			workbook.close();
		} catch (WriteException e) {

			e.printStackTrace();
		}

	}

}
