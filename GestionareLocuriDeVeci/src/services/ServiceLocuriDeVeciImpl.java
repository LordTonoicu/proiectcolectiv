package services;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import services.util.UtilInregistrareJurnal;
import validators.LocDeVeciValidator;
import dao.DAOCimitire;
import dao.DAOContracteConcesiune;
import dao.DAOJurnal;
import dao.DAOLocuri;
import dao.DAOParcele;
import dao.IDAOCimitire;
import dao.IDAOContracteConcesiune;
import dao.IDAOJurnal;
import dao.IDAOLocuri;
import dao.IDAOParcele;
import domain.LocDeVeci;
import dto.LocDeVeciDTO;
import exceptions.BusinessException;
import exceptions.ValidatorException;

public class ServiceLocuriDeVeciImpl implements ServiceLocuriDeVeci {

	private IDAOLocuri daoLocuri;
	private IDAOParcele daoParcele;
	private LocDeVeciValidator locDeVeciValidator;
	private IDAOJurnal daoJurnal;
	private IDAOContracteConcesiune daoContracteConcesiune;
	private IDAOCimitire daoCimitire;

	public void setDaoLocuri(DAOLocuri daoLocuri) {
		this.daoLocuri = daoLocuri;
	}

	public void setLocDeVeciValidator(LocDeVeciValidator locDeVeciValidator) {
		this.locDeVeciValidator = locDeVeciValidator;
	}
	
	public void setDaoParcele(IDAOParcele daoParcele) {
		this.daoParcele = daoParcele;
	}

	public ServiceLocuriDeVeciImpl(DAOLocuri daoLocuri,
			LocDeVeciValidator locDeVeciValidator) {
		super();
		this.daoLocuri = daoLocuri;
		this.locDeVeciValidator = locDeVeciValidator;
	}

	public ServiceLocuriDeVeciImpl() {
		super();
		this.daoLocuri = new DAOLocuri();
		this.locDeVeciValidator = new LocDeVeciValidator();
		this.daoParcele = new DAOParcele();
		this.daoJurnal = new DAOJurnal();
		this.daoCimitire = new DAOCimitire();
		this.daoContracteConcesiune = new DAOContracteConcesiune();
	}

	@Override
	public void trimiteEmailConcesionar(int locDeVeciExpirat) {
		// TODO Auto-generated method stub
	}

	@Override
	public void adaugaLocDeVeci(LocDeVeci locDeVeci, String user) throws BusinessException {
		try {
			locDeVeciValidator.validate(locDeVeci);
			daoLocuri.insert(locDeVeci);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "adaugare", locDeVeci.toString()));
		} catch (ValidatorException validatorException) {
			throw new BusinessException("Validation exception: "
					+ validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: "
					+ sqlException.getMessage());
		}
	}

	@Override
	public void actualizeazaLocDeVeci(LocDeVeci locDeVeci, String user)
			throws BusinessException {
		try {
			locDeVeciValidator.validate(locDeVeci);
			LocDeVeci anterior = daoLocuri.getById(locDeVeci.getIdLoc());
			daoLocuri.update(locDeVeci);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "actualizare", anterior.toString(), locDeVeci.toString()));
		} catch (ValidatorException validatorException) {
			throw new BusinessException("Validation exception: "
					+ validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: "
					+ sqlException.getMessage());
		}

	}

	@Override
	public void stergeLocDeVeci(LocDeVeci locDeVeci, String user) throws BusinessException {
		try {
			daoLocuri.delete(locDeVeci);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "stergere", locDeVeci.toString()));
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: "
					+ sqlException.getMessage());
		}
	}

	@Override
	public List<LocDeVeci> getLocuriDeVeciExpirate(int anulExpirarii) throws BusinessException {
		List<LocDeVeci> rezultat = null;
		try{
			List<LocDeVeci> locuriDeVeci = daoLocuri.getAll();
			rezultat = new ArrayList<LocDeVeci>();
			for (LocDeVeci locDeVeci: locuriDeVeci){
				Date dataConcesionare = daoContracteConcesiune.getByNumarContract(locDeVeci.getNrContractConcesionare()).getDataEliberare();
			    Calendar dataExpirarii = Calendar.getInstance();
			    dataExpirarii.setTime(dataConcesionare);
				if (dataExpirarii.get(Calendar.YEAR) == anulExpirarii){
					rezultat.add(locDeVeci);
				}
			}
		} catch (SQLException sqlException){
			throw new BusinessException(sqlException.getMessage());
		}
		return rezultat;
	}

	@Override
	public List<LocDeVeciDTO> getLocuriDeVeciExpirate() throws BusinessException{
		List<LocDeVeciDTO> rezultat = new ArrayList<LocDeVeciDTO>();
		try{
			List<LocDeVeci> locuriDeVeci = daoLocuri.getAll();
			
			for (LocDeVeci locDeVeci: locuriDeVeci){
				if(locDeVeci.getNrContractConcesionare()!=0){
				Date dataConcesionare = daoContracteConcesiune.getByNumarContract(locDeVeci.getNrContractConcesionare()).getDataEliberare();
			    Calendar dataExpirarii = Calendar.getInstance();
			    dataExpirarii.setTime(dataConcesionare);
			    dataExpirarii.add(Calendar.YEAR, 20);
				Calendar dataCurenta = Calendar.getInstance();
				if (dataExpirarii.before(dataCurenta)){
					LocDeVeciDTO locDeVeciDTO = new LocDeVeciDTO();
					locDeVeciDTO.setDenumireCimitir(daoCimitire.getById(locDeVeci.getIdCimitir()).getDenumire());
					rezultat.add(locDeVeciDTO);
					locDeVeciDTO.setLocDeVeci(locDeVeci);
					locDeVeciDTO.setDenumireParcela(daoParcele.getById(locDeVeci.getIdParcela()).getDenumire());
				}
				
			}
			}
		} catch (SQLException sqlException){
			throw new BusinessException(sqlException.getMessage());
		}
		return rezultat;
	}

	@Override
	public List<LocDeVeci> getLocuriDeVeciExpirandInAnulCurent() throws BusinessException{
		List<LocDeVeci> rezultat = null;
		try{
			List<LocDeVeci> locuriDeVeci = daoLocuri.getAll();
			rezultat = new ArrayList<LocDeVeci>();
			for (LocDeVeci locDeVeci: locuriDeVeci){
				Date dataConcesionare = daoContracteConcesiune.getByNumarContract(locDeVeci.getNrContractConcesionare()).getDataEliberare();
			    Calendar dataExpirarii = Calendar.getInstance();
			    dataExpirarii.setTime(dataConcesionare);
			    dataExpirarii.add(Calendar.YEAR, 20);
				Calendar dataCurenta = Calendar.getInstance();
				if (dataExpirarii.get(Calendar.YEAR) == dataCurenta.get(Calendar.YEAR)){
					rezultat.add(locDeVeci);
				}
			}
		} catch (SQLException sqlException){
			throw new BusinessException(sqlException.getMessage());
		}
		return rezultat;
	}

	@Override
	public List<LocDeVeci> getLocuriDeVeciPlatiteInAnulInCurs() throws BusinessException{
		List<LocDeVeci> rezultat = null;
		try{
			List<LocDeVeci> locuriDeVeci = daoLocuri.getAll();
			rezultat = new ArrayList<LocDeVeci>();
			for (LocDeVeci locDeVeci: locuriDeVeci){
				Date dataConcesionare = daoContracteConcesiune.getByNumarContract(locDeVeci.getNrContractConcesionare()).getDataEliberare();
			    Calendar dataExpirarii = Calendar.getInstance();
			    dataExpirarii.setTime(dataConcesionare);
			    Calendar dataCurenta = Calendar.getInstance();
				if (dataExpirarii.get(Calendar.YEAR) == dataCurenta.get(Calendar.YEAR)){
					rezultat.add(locDeVeci);
				}
			}
		} catch (SQLException sqlException){
			throw new BusinessException(sqlException.getMessage());
		}
		return rezultat;
	}

	@Override
	public List<LocDeVeci> getLocuriDeVeci() throws BusinessException {
		List<LocDeVeci> raspuns = null;
		try {
			raspuns = daoLocuri.getAll();
		} catch (SQLException sqlException) {
			throw new BusinessException(sqlException.getMessage());
		}
		return raspuns;
	}

	@Override
	public List<LocDeVeciDTO> getLocuriDeVeciByIdParcela(int idParcela)
			throws BusinessException {
		List<LocDeVeciDTO> raspuns  = new ArrayList<LocDeVeciDTO>();
		try{
			String denumireParcela = daoParcele.getById(idParcela).getDenumire();
			List<LocDeVeci> locuriDeVeci = daoLocuri.getAll();
			for (LocDeVeci locDeVeci: locuriDeVeci){
				if (locDeVeci.getIdParcela() == idParcela){
					LocDeVeciDTO locDeVeciDTO = new LocDeVeciDTO();
					locDeVeciDTO.setLocDeVeci(locDeVeci);
					locDeVeciDTO.setDenumireParcela(denumireParcela);
					raspuns.add(locDeVeciDTO);
				}
			}
		} catch (SQLException sqlException){
			throw new BusinessException(sqlException.getMessage());
		}
		return raspuns;
	}

	@Override
	public LocDeVeci getById(int id) throws BusinessException {
		LocDeVeci locDeVeci = null;
		try{
			locDeVeci = daoLocuri.getById(id);
		} catch (SQLException sqlException){
			throw new BusinessException(sqlException.getMessage());
		}
		return locDeVeci;
	}

	@Override
	public void deleteContractConcesiune(int nrContract,String user) throws BusinessException {
		LocDeVeci locDeVeci = null;
		try{
			locDeVeci = daoLocuri.getByNrContract(nrContract);
			locDeVeci.setNrContractConcesionare(0);
			actualizeazaLocDeVeci(locDeVeci, user);
		} catch (SQLException sqlException){
			throw new BusinessException(sqlException.getMessage());
		}
		
		
		
	}
}
