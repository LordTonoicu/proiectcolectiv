package tests;

import java.sql.SQLException;

import dao.DAODecedati;
import dao.IDAODecedati;
import domain.Decedat;



public class Application {

	public static void main(String args[]) {
		
		IDAODecedati in = new DAODecedati();
		
		try{
			Decedat decedat = in.getByCNP("aaa");
			System.out.println(decedat);
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
}
