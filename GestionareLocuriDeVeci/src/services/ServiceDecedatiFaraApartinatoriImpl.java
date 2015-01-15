package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import services.util.UtilInregistrareJurnal;
import validators.DatePersonaleValidator;
import validators.DecedatFaraApartinatoriValidator;
import validators.DecedatValidator;
import dao.DAODatePersonale;
import dao.DAODecedati;
import dao.DAODecedatiFaraApartinator;
import dao.DAOJurnal;
import dao.DAOLocuri;
import dao.IDAODatePersonale;
import dao.IDAODecedati;
import dao.IDAODecedatiFaraAparatinator;
import dao.IDAOJurnal;
import dao.IDAOLocuri;
import domain.DatePersonale;
import domain.Decedat;
import domain.DecedatFaraApartinatori;
import dto.DecedatDTO;
import dto.DecedatFaraApartinatoriDTO;
import exceptions.BusinessException;
import exceptions.ValidatorException;

public class ServiceDecedatiFaraApartinatoriImpl implements ServiceDecedatiFaraApartinatori{
	
	private IDAODecedatiFaraAparatinator daoDecedati;
	private IDAODatePersonale daoDatePersonale;
	private DecedatFaraApartinatoriValidator decedatValidator;
	private DatePersonaleValidator datePersonaleValidator;
	private IDAOJurnal daoJurnal;
	private IDAOLocuri daoLocuri;
	
	public ServiceDecedatiFaraApartinatoriImpl() {
		super();
		this.daoDecedati=new DAODecedatiFaraApartinator();
		this.decedatValidator=new DecedatFaraApartinatoriValidator();
		this.daoDatePersonale = new DAODatePersonale();
		this.datePersonaleValidator = new DatePersonaleValidator();
		this.daoJurnal = new DAOJurnal();
		this.daoLocuri = new DAOLocuri();
	}
	
	public void setDaoJurnal(DAOJurnal daoJurnal) {
		this.daoJurnal = daoJurnal;
	}

	@Override
	public void inscrieDecedatFaraApartinator(DecedatFaraApartinatoriDTO decedatDTO, String user) throws BusinessException {
		try{
			decedatValidator.validate(decedatDTO.getDecedat());
			datePersonaleValidator.validate(decedatDTO.getDatePersonale());
			daoDatePersonale.insert(decedatDTO.getDatePersonale());
			daoDecedati.insert(decedatDTO.getDecedat());
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "adaugare", decedatDTO.getDecedat().toString()));
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		} catch (ValidatorException validatorException){
			throw new BusinessException("Validation exception:: " + validatorException.getMessage());
		}
	}

	@Override
	public void actualizeazaDecedatFaraApartinator(DecedatFaraApartinatoriDTO decedatDTO, String user)
			throws BusinessException {
		try{
			decedatValidator.validate(decedatDTO.getDecedat());
			datePersonaleValidator.validate(decedatDTO.getDatePersonale());
			DecedatFaraApartinatori anterior = daoDecedati.getByCNP(decedatDTO.getDecedat().getCnpDecedat());
			
			daoDatePersonale.update(decedatDTO.getDatePersonale());
			daoDecedati.update(decedatDTO.getDecedat());
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "actualizare", anterior.toString(), decedatDTO.getDecedat().toString()));
		} catch  (ValidatorException validatorException) {
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}
	


	@Override
	public void stergeDecedatFaraApartinator(DecedatFaraApartinatoriDTO decedatDTO, String user) throws BusinessException {
		try{			
			daoDatePersonale.delete(decedatDTO.getDatePersonale());
			daoDecedati.delete(decedatDTO.getDecedat());
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "stergere", decedatDTO.getDecedat().toString()));
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
	}
	
	@Override
	public List<DecedatFaraApartinatoriDTO> getDecedatiFaraApartinatori() throws BusinessException {
		List<DecedatFaraApartinatoriDTO> rezultat = null;
		try {
			List<DecedatFaraApartinatori> decedati = daoDecedati.getAllDecedatiFaraApartinatori();
		    rezultat = new ArrayList<DecedatFaraApartinatoriDTO>();
			for(DecedatFaraApartinatori decedat: decedati){
				DecedatFaraApartinatoriDTO decedatDTO = new DecedatFaraApartinatoriDTO();
				decedatDTO.setDecedat(decedat);
				DatePersonale datePersonale = daoDatePersonale.getDatePersonaleFromCNP(decedat.getCnpDecedat());
				decedatDTO.setDatePersonale(datePersonale);
				decedatDTO.setNumarLocDeVeci(daoLocuri.getById(decedat.getIdLocDeVeci()).getNumar());
				rezultat.add(decedatDTO);
			}
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return rezultat;
	}
	
}
