package services;

import java.util.List;

import domain.ContractConcesiune;
import dto.ContractConcesiuneDTO;
import exceptions.BusinessException;

public interface ServiceContracteConcesiune {
	public void adaugaContractConcesiune(ContractConcesiune contractConcesiune,String user) throws BusinessException;
	public void stergeContractConcesiune(ContractConcesiune contractConcesiune,String user) throws BusinessException;
	public void actualizeazaContractConcesiune(ContractConcesiune contractConcesiune,String user) throws BusinessException;
	public List<ContractConcesiuneDTO> getContracteConcesiune() throws BusinessException;
}
