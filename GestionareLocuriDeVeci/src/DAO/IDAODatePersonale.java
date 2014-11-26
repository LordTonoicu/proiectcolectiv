package DAO;

import java.sql.SQLException;

import Domain.DatePersonale;

public interface IDAODatePersonale {

	public void insert(DatePersonale datePersonale) throws SQLException;

	public void update(DatePersonale datePersonale) throws SQLException;
	
	public void delete(DatePersonale datePersonale) throws SQLException;
}
