package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Cimitir;

public interface IDAOCimitire {

	public void insert(Cimitir cimitir) throws SQLException;
	
	public void update(Cimitir cimitir) throws SQLException;
	
	public void delete(Cimitir cimitir) throws SQLException;
	
	public List<Cimitir> getAllCimitire() throws SQLException;
	
	public Cimitir getById (int id) throws SQLException;
}
