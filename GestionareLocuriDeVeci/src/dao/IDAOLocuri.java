package dao;

import java.sql.SQLException;
import java.util.List;

import domain.LocDeVeci;

public interface IDAOLocuri {

	public void insert(LocDeVeci locDeVeci) throws SQLException;

	public void update(LocDeVeci locDeVeci) throws SQLException;
	
	public void delete(LocDeVeci locDeVeci) throws SQLException;

	public List<LocDeVeci> getAll() throws SQLException;

	public LocDeVeci getById(int idLoc) throws SQLException;

}
