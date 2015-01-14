package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Concesionar;

public interface IDAOConcesionari {
	//TODO update deleted flag for all
	public void insert(Concesionar concesionar) throws SQLException;
	public void update(Concesionar concesionar) throws SQLException;
	public void delete(Concesionar concesionar) throws SQLException;
	public List<Concesionar> getAll () throws SQLException;
	public Concesionar getConcesionarById(int idConcesionar) throws SQLException;
	public Concesionar getConcesionarFromCNP(String CNP) throws SQLException;
}
