package Main;

import java.sql.SQLException;

import DAO.DAODecedati;
import DAO.IDAODecedati;
import Domain.Decedat;



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
