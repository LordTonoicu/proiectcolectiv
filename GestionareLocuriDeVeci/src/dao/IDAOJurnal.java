package dao;

import java.sql.SQLException;
import java.util.List;

import domain.InregistrareJurnal;

public interface IDAOJurnal {

	public void insert(InregistrareJurnal inregistrareJurnal) throws SQLException;

	public List<InregistrareJurnal> getAll() throws SQLException;
}
