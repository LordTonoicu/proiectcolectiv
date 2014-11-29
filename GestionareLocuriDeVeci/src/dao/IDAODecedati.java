package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Decedat;

public interface IDAODecedati {

	public void insert(Decedat decedat) throws SQLException;
	
	public void update(Decedat decedat) throws SQLException;
	
	public void delete(Decedat decedat) throws SQLException;
	
	public Decedat getByCNP(String CNP) throws SQLException;

	public List<Decedat> getAllDecedati() throws SQLException;
}
