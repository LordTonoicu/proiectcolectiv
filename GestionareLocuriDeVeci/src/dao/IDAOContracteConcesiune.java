package dao;


import java.util.List;

import domain.ContractConcesiune;

public interface IDAOContracteConcesiune {
	public void insert(ContractConcesiune cc);
	public void delete(ContractConcesiune cc);
	public void update(ContractConcesiune cc);
	public List<ContractConcesiune> getAll(); 
}
