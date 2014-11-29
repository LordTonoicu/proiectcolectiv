package dao;

import java.sql.SQLException;

import domain.LocDeVeci;

public interface IDAOLocuri {

	public void insert(LocDeVeci locDeVeci) throws SQLException;

	public void update(LocDeVeci locDeVeci) throws SQLException;
}
