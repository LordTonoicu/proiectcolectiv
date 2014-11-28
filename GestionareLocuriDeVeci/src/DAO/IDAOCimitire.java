package DAO;

import java.sql.SQLException;
import java.util.List;

import Domain.Cimitir;

public interface IDAOCimitire {

	public void insert(Cimitir cimitir) throws SQLException;
	
	public void update(Cimitir cimitir) throws SQLException;
	
	public void delete(Cimitir cimitir) throws SQLException;
	
	public List<Cimitir> getAllCimitire() throws SQLException;
}
