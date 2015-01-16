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
import domain.registers.InregRegDeMorminte;
import services.ServiceRegistre;
import services.ServiceRegistreImpl;
import exceptions.BusinessException;

/**
 * Servlet implementation class Table2Servlet
 */
@WebServlet("/Table2Servlet")
public class Table2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceRegistre serviceRegistre = new ServiceRegistreImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table2Servlet() {
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
		try{
			ArrayList<InregRegDeMorminte> registru = (ArrayList<InregRegDeMorminte>) serviceRegistre.getRegDeMorminte();
			if(request.getParameter("exportExcel")!=null){
				exportExcel(request,response,registru);
				return;
			}
			request.getSession().setAttribute("registru2",registru);
			response.sendRedirect("jsp/tables2.jsp");
		}catch(BusinessException ex)
		{
			request.getSession().setAttribute("exceptie",ex.getMessage());
			response.sendRedirect("jsp/exceptionPage.jsp");
		}
	}
	
	private void exportExcel(HttpServletRequest request,
			HttpServletResponse response,
			ArrayList<InregRegDeMorminte> registru) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition",
				"attachment; filename=registru2.xls");
		WritableWorkbook workbook = Workbook.createWorkbook(response
				.getOutputStream());
		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
		try {
			WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10);
			cellFont.setBoldStyle(WritableFont.BOLD);

			WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
			
			sheet.addCell(new Label(0, 0, "Cimitir",cellFormat));
			sheet.addCell(new Label(1, 0, "Parcela",cellFormat));
			sheet.addCell(new Label(2, 0, "Nr mormant",cellFormat));
			sheet.addCell(new Label(3, 0, "Suprafata",cellFormat));
			sheet.addCell(new Label(4, 0, "Nume Prenume detinatori",cellFormat));
			sheet.addCell(new Label(5, 0, "Domicilii detinatori",cellFormat));
			sheet.addCell(new Label(6, 0, "Nr chitante",cellFormat));
			sheet.addCell(new Label(7, 0, "Nume Prenume inmormantati",cellFormat));
			sheet.addCell(new Label(8, 0, "Date inmormantari",cellFormat));
			for (int i = 1; i < registru.size() + 1; i++) {
				sheet.addCell(new Label(0, i, registru.get(i-1).getCimitir()));
				sheet.addCell(new Label(1, i, registru.get(i-1).getParcela()));
				sheet.addCell(new Label(2, i, String.valueOf(registru.get(i-1).getNumarMormant())));
				sheet.addCell(new Label(3, i, String.valueOf(registru.get(i - 1).getSuprafata())));
				sheet.addCell(new Label(4, i, registru.get(i - 1).getNumePrenumeDetinatori().replaceAll("<br>", "\n ")));
				sheet.addCell(new Label(5, i, registru.get(i - 1).getDomiciliuDetinatori().replaceAll("<br>", "\n ")));
				sheet.addCell(new Label(6, i, registru.get(i - 1).getNumereChitante().replaceAll("<br>", "\n ")));
				sheet.addCell(new Label(7, i, registru.get(i - 1).getNumePrenumeInmormantati().replaceAll("<br>", "\n ")));
				sheet.addCell(new Label(8, i, String.valueOf(registru.get(i - 1).getDateInmormantare().replaceAll("<br>", "\n "))));
			}

			workbook.write();
			workbook.close();
		} catch (WriteException e) {

			e.printStackTrace();
		}

	}

}
