package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dao.DAOCimitire;
import dao.DAOJurnal;
import dao.DAOLocuri;
import dao.IDAOCimitire;
import dao.IDAOJurnal;
import dao.IDAOLocuri;
import domain.Cimitir;
import exceptions.BusinessException;
import exceptions.ValidatorException;
import services.util.UtilInregistrareJurnal;
import validators.CimitirValidator;

public class ServiceCimitireImpl implements ServiceCimitire{
	
	private IDAOCimitire daoCimitire;
	private CimitirValidator cimitirValidator;
	private IDAOJurnal daoJurnal;

	public ServiceCimitireImpl() {
		super();
		this.daoCimitire=new DAOCimitire();
		this.daoJurnal = new DAOJurnal();
		this.cimitirValidator=new CimitirValidator();
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
	public void adaugaCimitir(Cimitir cimitir, String user) throws BusinessException {
		try{
			cimitirValidator.validate(cimitir);
			daoCimitire.insert(cimitir);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "adaugare", cimitir.toString()));			
		} catch (ValidatorException validatorException){
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}

	@Override
	public void stergeCimitir(Cimitir cimitir, String user) throws BusinessException {
		try{
			daoCimitire.delete(cimitir);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "stergere", cimitir.toString()));
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}

	@Override
	public void actualizeazaCimitir(Cimitir cimitir, String user) throws BusinessException {
		try{
			cimitirValidator.validate(cimitir);
			Cimitir cimitirAnterior = daoCimitire.getById(cimitir.getIdCimitir());
			daoCimitire.update(cimitir);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "actualizare", cimitirAnterior.toString(), cimitir.toString()));
		} catch (ValidatorException validatorException){
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}

	@Override
	public List<Cimitir> getCimitire() throws BusinessException {
		try {
			return daoCimitire.getAllCimitire();
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
	
	}
}


	
	

