package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import validators.DatePersonaleValidator;
import validators.DecedatValidator;
import dao.DAODatePersonale;
import dao.DAODecedati;
import dao.IDAODatePersonale;
import dao.IDAODecedati;
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
	
	public ServiceDecedatiImpl() {
		super();
		this.daoDecedati=new DAODecedati();
		this.decedatValidator=new DecedatValidator();
		this.daoDatePersonale = new DAODatePersonale();
	}

	@Override
	public void inscrieDecedat(DecedatDTO decedatDTO, String user) throws BusinessException {
		try{
			decedatValidator.validate(decedatDTO.getDecedat());
			datePersonaleValidator.validate(decedatDTO.getDatePersonale());
			daoDatePersonale.insert(decedatDTO.getDatePersonale());
			daoDecedati.insert(decedatDTO.getDecedat());
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
			daoDatePersonale.update(decedatDTO.getDatePersonale());
			daoDecedati.update(decedatDTO.getDecedat());
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
				rezultat.add(decedatDTO);
			}
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return rezultat;
	}
}
