package services;

import java.util.List;

import domain.ContractConcesiune;
import exceptions.BusinessException;

public interface ServiceContracteConcesiune {
	public void adaugaContractConcesiune(ContractConcesiune contractConcesiune) throws BusinessException;
	public void stergeContractConcesiune(ContractConcesiune contractConcesiune) throws BusinessException;
	public void actualizeazaContractConcesiune(ContractConcesiune contractConcesiune) throws BusinessException;
	public List<ContractConcesiune> getContracteConcesiune() throws BusinessException;
}
