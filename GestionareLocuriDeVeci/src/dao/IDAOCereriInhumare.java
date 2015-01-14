package dao;

import java.sql.SQLException;
import java.util.List;

import domain.CerereInhumare;

public interface IDAOCereriInhumare {
	public void insert(CerereInhumare cerereInhumare) throws SQLException;

	public void update(CerereInhumare cerereInhumare) throws SQLException;

	public void delete(CerereInhumare cerereInhumare) throws SQLException;

	public List<CerereInhumare> getAll() throws SQLException;
	
	public CerereInhumare getByNrCerere(int nrCerere) throws SQLException;
}
