package dao;


import java.sql.SQLException;
import java.util.List;

import domain.ContractConcesiune;

public interface IDAOContracteConcesiune {
	public void insert(ContractConcesiune cc) throws SQLException;
	public void delete(ContractConcesiune cc) throws SQLException;
	public void update(ContractConcesiune cc) throws SQLException;
	public List<ContractConcesiune> getAll() throws SQLException; 
	public ContractConcesiune getByNumarContract(int id) throws SQLException;
}
