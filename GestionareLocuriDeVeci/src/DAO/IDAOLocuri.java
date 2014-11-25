package DAO;

import java.sql.SQLException;

import Domain.LocDeVeci;

public interface IDAOLocuri {

	public void insert(LocDeVeci locDeVeci) throws SQLException;

	public void update(LocDeVeci locDeVeci) throws SQLException;
}
