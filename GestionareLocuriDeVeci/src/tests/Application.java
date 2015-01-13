package tests;

import java.sql.SQLException;

import services.ServiceLocuriDeVeci;
import services.ServiceLocuriDeVeciImpl;
import services.ServiceParcele;
import services.ServiceParceleImpl;
import dao.DAODecedati;
import dao.IDAODecedati;
import domain.Decedat;
import domain.LocDeVeci;
import exceptions.BusinessException;



public class Application {

	public static void main(String args[]) {
		
		IDAODecedati in = new DAODecedati();
		
		try{
//			Decedat decedat = in.getByCNP("aaa");
//			System.out.println(decedat);
			ServiceLocuriDeVeci parla = new ServiceLocuriDeVeciImpl();
			LocDeVeci locDeVeci = new LocDeVeci();
			parla.adaugaLocDeVeci(locDeVeci," ");
			System.out.println();
			
		

			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
