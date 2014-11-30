package dao;

import java.sql.SQLException;

import domain.Concesionar;
import domain.DatePersonale;
import domain.Decedat;

public interface IDAODatePersonale {

	public void insert(DatePersonale datePersonale) throws SQLException;

	public void update(DatePersonale datePersonale) throws SQLException;
	
	public void delete(DatePersonale datePersonale) throws SQLException;
	
	//Cred ca metoda imediat urm. e suficienta
	public DatePersonale getDatePersonaleFromDecedat(Decedat decedat) throws SQLException;
	
	public DatePersonale getDatePersonaleFromCNP(String CNP) throws SQLException;
}
