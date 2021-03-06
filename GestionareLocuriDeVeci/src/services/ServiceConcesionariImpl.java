package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import services.util.UtilInregistrareJurnal;
import validators.ConcesionarValidator;
import validators.DatePersonaleValidator;
import dao.DAOConcesionari;
import dao.DAODatePersonale;
import dao.DAOJurnal;
import dao.IDAOConcesionari;
import dao.IDAODatePersonale;
import dao.IDAOJurnal;
import domain.Concesionar;
import domain.DatePersonale;
import dto.ConcesionarDTO;
import exceptions.BusinessException;
import exceptions.ValidatorException;


public class ServiceConcesionariImpl implements ServiceConcesionari{

	private IDAODatePersonale daoDatePersonale;
	private DatePersonaleValidator datePersonaleValidator;
	private IDAOConcesionari daoConcesionari;
	private ConcesionarValidator concesionarValidator;
	private IDAOJurnal daoJurnal;
	
	public void setDaoDatePersonale(IDAODatePersonale daoDatePersonale) {
		this.daoDatePersonale = daoDatePersonale;
	}

	public void setDatePersonaleValidator(
			DatePersonaleValidator datePersonaleValidator) {
		this.datePersonaleValidator = datePersonaleValidator;
	}

	public void setDaoConcesionari(IDAOConcesionari daoConcesionari) {
		this.daoConcesionari = daoConcesionari;
	}

	public void setConcesionarValidator(ConcesionarValidator concesionarValidator) {
		this.concesionarValidator = concesionarValidator;
	}


	public void setDaoJurnal(IDAOJurnal daoJurnal) {
		this.daoJurnal = daoJurnal;
	}

	public ServiceConcesionariImpl() {
		super();
		this.daoDatePersonale = new DAODatePersonale();
		this.datePersonaleValidator = new DatePersonaleValidator();
		this.daoConcesionari = new DAOConcesionari();
		this.concesionarValidator = new ConcesionarValidator();
		this.daoJurnal = new DAOJurnal();
	}

	public ServiceConcesionariImpl(IDAODatePersonale daoDatePersonale,
			DatePersonaleValidator datePersonaleValidator,
			IDAOConcesionari daoConcesionari,
			ConcesionarValidator concesionarValidator) {
		super();
		this.daoDatePersonale = daoDatePersonale;
		this.datePersonaleValidator = datePersonaleValidator;
		this.daoConcesionari = daoConcesionari;
		this.concesionarValidator = concesionarValidator;
	}

	@Override
	public void adaugaConcesionar(ConcesionarDTO concesionarDTO, String user) throws BusinessException {
		try{
			concesionarValidator.validate(concesionarDTO.getConcesionar());
			datePersonaleValidator.validate(concesionarDTO.getDatePersonale());
			daoDatePersonale.insert(concesionarDTO.getDatePersonale());
			daoConcesionari.insert(concesionarDTO.getConcesionar());
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "adaugare", concesionarDTO.getConcesionar().toString()));
		} catch  (ValidatorException validatorException) {
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
	}

	@Override
	public void actualizeazaConcesionar(ConcesionarDTO concesionarDTO, String user)
			throws BusinessException {
		try{
			concesionarValidator.validate(concesionarDTO.getConcesionar());
			datePersonaleValidator.validate(concesionarDTO.getDatePersonale());
			Concesionar anterior = daoConcesionari.getConcesionarById(concesionarDTO.getConcesionar().getIdConcesionar());
			daoDatePersonale.update(concesionarDTO.getDatePersonale());
			daoConcesionari.update(concesionarDTO.getConcesionar());
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "actualizare", anterior.toString(), concesionarDTO.getConcesionar().toString()));
		} catch  (ValidatorException validatorException) {
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}

	@Override
	public void stergeConcesionar(ConcesionarDTO concesionarDTO, String user)
			throws BusinessException {
		try{
			daoConcesionari.delete(concesionarDTO.getConcesionar());
			daoDatePersonale.delete(concesionarDTO.getDatePersonale());
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "stergere", concesionarDTO.toString()));
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
	}

	@Override
	public List<ConcesionarDTO> getConcesionari() throws BusinessException{
		List<ConcesionarDTO> rezultat = null;
		try{
		   List<Concesionar> concesionari = daoConcesionari.getAll();
		   rezultat = new ArrayList<ConcesionarDTO>();
		   for (Concesionar concesionar: concesionari){
			   ConcesionarDTO concesionarDTO = new ConcesionarDTO();
			   concesionarDTO.setConcesionar(concesionar);
			   DatePersonale datePersonale = daoDatePersonale.getDatePersonaleFromCNP(concesionar.getCnpConcesionar());
			   concesionarDTO.setDatePersonale(datePersonale);
			   rezultat.add(concesionarDTO);
		   }
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return rezultat;
	}
	
	
	
}
