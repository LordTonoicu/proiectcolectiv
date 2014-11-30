package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Concesionar;

public interface IDAOConcesionari {

	public void insert(Concesionar concesionar) throws SQLException;
	public void update(Concesionar concesionar) throws SQLException;
	public void delete(Concesionar concesionar) throws SQLException;
	public List<Concesionar> getAll () throws SQLException;
}
