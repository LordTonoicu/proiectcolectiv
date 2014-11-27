package services.impl;

import java.sql.SQLException;

import DAO.DAOParcele;
import Domain.Parcela;
import exceptions.BusinessException;
import exceptions.ValidatorException;
import services.api.ServiceParcele;
import validators.ParcelaValidator;

public class ServiceParceleImpl implements ServiceParcele{

	private ParcelaValidator parcelaValidator;
	private DAOParcele daoParcele;
	
	public ServiceParceleImpl() {
		super();
	}

	public ServiceParceleImpl(ParcelaValidator parcelaValidator,
			DAOParcele daoParcele) {
		super();
		this.parcelaValidator = parcelaValidator;
		this.daoParcele = daoParcele;
	}

	public void setParcelaValidator(ParcelaValidator parcelaValidator) {
		this.parcelaValidator = parcelaValidator;
	}

	public void setDaoParcele(DAOParcele daoParcele) {
		this.daoParcele = daoParcele;
	}

	@Override
	public void adaugaParcela(Parcela parcela) throws BusinessException {
		try {
			parcelaValidator.validate(parcela);
			daoParcele.insert(parcela);
		} catch (ValidatorException validatorException){
			throw new BusinessException(validatorException.getMessage());
		} catch (SQLException sqlException){
			     //La nivelul DAO ar trebui sa se arunce o exceptie mai generica (DataAccessException)
			throw new BusinessException(sqlException.getMessage());
		}
		
	}

	@Override
	public void stergeParcela(Parcela parcela) throws BusinessException {
		try {
			daoParcele.delete(parcela);
		} catch (SQLException sqlException){
			 throw new BusinessException(sqlException.getMessage());
		}
	}

	@Override
	public void actualizeazaParcela(Parcela parcela) throws BusinessException {
		try {
			parcelaValidator.validate(parcela);
			daoParcele.update(parcela);
		} catch (ValidatorException validatorException){
			throw new BusinessException(validatorException.getMessage());
		} catch (SQLException sqlException){
			throw new BusinessException(sqlException.getMessage());
		}
	}

}
