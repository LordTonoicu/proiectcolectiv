package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Decedat;
import domain.DecedatFaraApartinatori;

public interface IDAODecedatiFaraAparatinator {

	public void insert(DecedatFaraApartinatori decedat) throws SQLException;
	
	public void update(DecedatFaraApartinatori decedat) throws SQLException;
	
	public void delete(DecedatFaraApartinatori decedat) throws SQLException;
	
	public DecedatFaraApartinatori getByCNP(String CNP) throws SQLException;

	public List<DecedatFaraApartinatori> getAllDecedatiFaraApartinatori() throws SQLException;
}
