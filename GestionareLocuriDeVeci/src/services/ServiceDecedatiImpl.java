package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import services.util.UtilInregistrareJurnal;
import validators.DatePersonaleValidator;
import validators.DecedatValidator;
import dao.DAODatePersonale;
import dao.DAODecedati;
import dao.DAOJurnal;
import dao.DAOLocuri;
import dao.IDAODatePersonale;
import dao.IDAODecedati;
import dao.IDAOJurnal;
import dao.IDAOLocuri;
import domain.DatePersonale;
import domain.Decedat;
import dto.DecedatDTO;
import exceptions.BusinessException;
import exceptions.ValidatorException;

public class ServiceDecedatiImpl implements ServiceDecedati{
	
	private IDAODecedati daoDecedati;
	private IDAODatePersonale daoDatePersonale;
	private DecedatValidator decedatValidator;
	private DatePersonaleValidator datePersonaleValidator;
	private IDAOJurnal daoJurnal;
	private IDAOLocuri daoLocuri;
	
	public ServiceDecedatiImpl() {
		super();
		this.daoDecedati=new DAODecedati();
		this.decedatValidator=new DecedatValidator();
		this.daoDatePersonale = new DAODatePersonale();
		this.datePersonaleValidator = new DatePersonaleValidator();
		this.daoJurnal = new DAOJurnal();
		this.daoLocuri = new DAOLocuri();
	}
	
	public void setDaoJurnal(DAOJurnal daoJurnal) {
		this.daoJurnal = daoJurnal;
	}

	@Override
	public void inscrieDecedat(DecedatDTO decedatDTO, String user) throws BusinessException {
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
	public void actualizeazaDecedat(DecedatDTO decedatDTO, String user)
			throws BusinessException {
		try{
			decedatValidator.validate(decedatDTO.getDecedat());
			datePersonaleValidator.validate(decedatDTO.getDatePersonale());
			Decedat anterior = daoDecedati.getByCNP(decedatDTO.getDecedat().getCnpDecedat());
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
	public void stergeDecedat(DecedatDTO decedatDTO, String user) throws BusinessException {
		try{			
			
			daoDecedati.delete(decedatDTO.getDecedat());
			daoDatePersonale.delete(decedatDTO.getDatePersonale());
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "stergere", decedatDTO.getDecedat().toString()));
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
	}
	
	@Override
	public List<DecedatDTO> getDecedati() throws BusinessException {
		List<DecedatDTO> rezultat = null;
		try {
			List<Decedat> decedati = daoDecedati.getAllDecedati();
		    rezultat = new ArrayList<DecedatDTO>();
			for(Decedat decedat: decedati){
				DecedatDTO decedatDTO = new DecedatDTO();
				decedatDTO.setDecedat(decedat);
				DatePersonale datePersonale = daoDatePersonale.getDatePersonaleFromCNP(decedat.getCnpDecedat());
				decedatDTO.setDatePersonale(datePersonale);
				decedatDTO.setNumarLocDeVeci(daoLocuri.getById(decedat.getIdLocDeVeci()).getNumar());
				if(decedatDTO!=null && decedat!=null)
					rezultat.add(decedatDTO);
			}
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return rezultat;
	}
}
