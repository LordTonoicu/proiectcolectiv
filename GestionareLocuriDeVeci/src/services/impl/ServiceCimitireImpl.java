package services.impl;

import java.sql.SQLException;

import exceptions.BusinessException;
import exceptions.ValidatorException;
import DAO.DAOCimitire;
import Domain.Cimitir;
import services.api.ServiceCimitire;
import validators.CimitirValidator;

public class ServiceCimitireImpl implements ServiceCimitire{
	
	private DAOCimitire daoCimitire;
	private CimitirValidator cimitirValidator;

	public ServiceCimitireImpl() {
		super();
	}

	public ServiceCimitireImpl(DAOCimitire daoCimitire,
			validators.CimitirValidator cimitirValidator) {
		super();
		this.daoCimitire = daoCimitire;
		this.cimitirValidator = cimitirValidator;
	}

	public void setDaoCimitire(DAOCimitire daoCimitire) {
		this.daoCimitire = daoCimitire;
	}

	public void setCimitirValidator(CimitirValidator cimitirValidator) {
		this.cimitirValidator = cimitirValidator;
	}

	@Override
	public void adaugaCimitir(Cimitir cimitir) throws BusinessException {
		try{
			cimitirValidator.validate(cimitir);
			daoCimitire.insert(cimitir);
		} catch (ValidatorException validatorException){
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}

	@Override
	public void stergeCimitir(Cimitir cimitir) throws BusinessException {
		try{
			daoCimitire.delete(cimitir);
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}

	@Override
	public void actualizeazaCimitir(Cimitir cimitir) throws BusinessException {
		try{
			cimitirValidator.validate(cimitir);
			daoCimitire.update(cimitir);
		} catch (ValidatorException validatorException){
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}
}


	
	

