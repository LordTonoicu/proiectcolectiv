package services;

import java.sql.SQLException;
import java.util.List;

import validators.ContractConcesiuneValidator;
import dao.DAOContracteConcesiune;
import domain.ContractConcesiune;
import exceptions.BusinessException;
import exceptions.ValidatorException;

public class ServiceContracteConcesiuneImpl implements ServiceContracteConcesiune{

	private ContractConcesiuneValidator validator;
	private DAOContracteConcesiune daoContracteConcesiune;
	
	public ServiceContracteConcesiuneImpl() {
		this.validator = new ContractConcesiuneValidator();
		this.daoContracteConcesiune = new DAOContracteConcesiune();
	}
	
	@Override
	public void adaugaContractConcesiune(ContractConcesiune contractConcesiune)
			throws BusinessException {
		try{
			validator.validate(contractConcesiune);
			daoContracteConcesiune.insert(contractConcesiune);
		} catch (ValidatorException validatorException){
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
			
	}

	@Override
	public void stergeContractConcesiune(ContractConcesiune contractConcesiune)
			throws BusinessException {
		try{
			daoContracteConcesiune.delete(contractConcesiune);
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}

	@Override
	public void actualizeazaContractConcesiune(
			ContractConcesiune contractConcesiune) throws BusinessException {
		try{
			validator.validate(contractConcesiune);
			daoContracteConcesiune.update(contractConcesiune);
		} catch (ValidatorException validatorException){
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}

	@Override
	public List<ContractConcesiune> getContracteConcesiune()
			throws BusinessException {
		List<ContractConcesiune> result = null;
		try{
			result = daoContracteConcesiune.getAll();
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return result;
	}

}
