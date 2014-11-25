package DAO;

import java.sql.SQLException;

import Domain.Concesionar;

public interface IDAOConcesionari {

	public void insert(Concesionar concesionar) throws SQLException;
}
