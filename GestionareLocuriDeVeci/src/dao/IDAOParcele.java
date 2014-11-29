package dao;

import java.sql.SQLException;

import domain.Parcela;

public interface IDAOParcele {

	public void insert(Parcela parcela) throws SQLException;

	public void update(Parcela parcela) throws SQLException;

	public void delete(Parcela parcela) throws SQLException;
}
