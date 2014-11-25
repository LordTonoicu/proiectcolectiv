package DAO;

import java.sql.SQLException;

import Domain.Parcela;

public interface IDAOParcele {

	public void insert(Parcela parcela) throws SQLException;

	public void update(Parcela parcela) throws SQLException;

	public void delete(Parcela parcela) throws SQLException;
}
