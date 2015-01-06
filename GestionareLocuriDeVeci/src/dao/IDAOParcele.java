package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Parcela;

public interface IDAOParcele {

	public void insert(Parcela parcela) throws SQLException;

	public void update(Parcela parcela) throws SQLException;

	public void delete(Parcela parcela) throws SQLException;
	
	public List<Parcela> getAllParcele() throws SQLException;
	//TODO implement this!?
	public Parcela getById (int id) throws SQLException;;
}
