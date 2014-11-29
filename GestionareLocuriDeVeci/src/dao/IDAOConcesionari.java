package dao;

import java.sql.SQLException;

import domain.Concesionar;

public interface IDAOConcesionari {

	public void insert(Concesionar concesionar) throws SQLException;
}
