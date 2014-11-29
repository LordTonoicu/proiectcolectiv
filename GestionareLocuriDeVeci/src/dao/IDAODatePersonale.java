package dao;

import java.sql.SQLException;

import domain.DatePersonale;

public interface IDAODatePersonale {

	public void insert(DatePersonale datePersonale) throws SQLException;

	public void update(DatePersonale datePersonale) throws SQLException;
	
	public void delete(DatePersonale datePersonale) throws SQLException;
}
