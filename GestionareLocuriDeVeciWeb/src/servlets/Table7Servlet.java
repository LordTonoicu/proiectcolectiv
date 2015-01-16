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
import services.ServiceRegistre;
import services.ServiceRegistreImpl;
import domain.registers.InregRegAnualDeProgrInmormantari;
import domain.registers.InregRegCereriInhumare;
import domain.registers.InregRegContracteConcesiune;
import exceptions.BusinessException;

/**
 * Servlet implementation class Table7Servlet
 */
@WebServlet("/Table7Servlet")
public class Table7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceRegistre serviceRegistre = new ServiceRegistreImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Table7Servlet() {
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
			ArrayList<InregRegContracteConcesiune> registru = (ArrayList<InregRegContracteConcesiune>) serviceRegistre
					.getRegContracteConcesiune();
			if (request.getParameter("exportExcel") != null) {
				exportExcel(request, response, registru);
				return;
			}
			request.getSession().setAttribute("registru7", registru);
			response.sendRedirect("jsp/tables7.jsp");
		} catch (BusinessException ex) {
			request.getSession().setAttribute("exceptie", ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}

	private void exportExcel(HttpServletRequest request,
			HttpServletResponse response,
			ArrayList<InregRegContracteConcesiune> registru) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition",
				"attachment; filename=registru7.xls");
		WritableWorkbook workbook = Workbook.createWorkbook(response
				.getOutputStream());
		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
		try {
			WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
			cellFont.setBoldStyle(WritableFont.BOLD);

			WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
			
			sheet.addCell(new Label(0, 0, "Nr Curent",cellFormat));
			sheet.addCell(new Label(1, 0, "Nr Contract",cellFormat));
			sheet.addCell(new Label(2, 0, "Data Eliberarii Contractului",cellFormat));
			sheet.addCell(new Label(3, 0, "Nume",cellFormat));
			sheet.addCell(new Label(4, 0, "Prenume",cellFormat));
			sheet.addCell(new Label(5, 0, "Adresa",cellFormat));
			for (int i = 1; i < registru.size() + 1; i++) {
				sheet.addCell(new Label(0, i, String.valueOf(registru
						.get(i - 1).getNrCurent())));
				sheet.addCell(new Label(1, i, String.valueOf(registru
						.get(i - 1).getNrContract())));
				sheet.addCell(new Label(2, i, String.valueOf(registru
						.get(i - 1).getDataEliberare())));
				sheet.addCell(new Label(3, i, registru.get(i - 1).getNume()));
				sheet.addCell(new Label(4, i, registru.get(i - 1).getPrenume()));
				sheet.addCell(new Label(5, i, registru.get(i - 1).getAdresa()));
			}

			workbook.write();
			workbook.close();
		} catch (WriteException e) {

			e.printStackTrace();
		}

	}

}
