package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
import domain.registers.InregRegCereriInhumare;
import exceptions.BusinessException;
import services.ServiceRegistre;
import services.ServiceRegistreImpl;

/**
 * Servlet implementation class Table6Servlet
 */
@WebServlet("/Table6Servlet")
public class Table6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceRegistre serviceRegistre = new ServiceRegistreImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Table6Servlet() {
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
			ArrayList<InregRegCereriInhumare> registru = (ArrayList<InregRegCereriInhumare>) serviceRegistre
					.getRegCereriInhumare();
			if (request.getParameter("exportExcel") != null) {
				exportExcel(request, response, registru);
				return;
			}
			request.getSession().setAttribute("registru6", registru);
			response.sendRedirect("jsp/tables6.jsp");
		} catch (BusinessException ex) {
			request.getSession().setAttribute("exceptie", ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}

	private void exportExcel(HttpServletRequest request,
			HttpServletResponse response,
			ArrayList<InregRegCereriInhumare> registru) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition",
				"attachment; filename=registru6.xls");
		WritableWorkbook workbook = Workbook.createWorkbook(response
				.getOutputStream());
		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
		try {
			WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
			cellFont.setBoldStyle(WritableFont.BOLD);

			WritableCellFormat cellFormat = new WritableCellFormat(cellFont);

			sheet.addCell(new Label(0, 0, "Data Inregistrare", cellFormat));
			sheet.addCell(new Label(1, 0, "Nr Cerere", cellFormat));
			sheet.addCell(new Label(2, 0, "Stadiu Solutionare", cellFormat));
			for (int i = 1; i < registru.size() + 1; i++) {
				sheet.addCell(new Label(0, i, String.valueOf(registru
						.get(i - 1).getDataInregistrare())));
				sheet.addCell(new Label(1, i, String.valueOf(registru
						.get(i - 1).getNrCerere())));
				sheet.addCell(new Label(2, i, registru.get(i - 1)
						.getStadiuSolutionare()));
			}

			workbook.write();
			workbook.close();
		} catch (WriteException e) {

			e.printStackTrace();
		}

	}

}
