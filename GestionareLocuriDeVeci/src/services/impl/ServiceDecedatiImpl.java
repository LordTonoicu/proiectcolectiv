package services.impl;

import java.sql.SQLException;
import java.util.List;

import javax.xml.crypto.Data;

import DAO.DAODatePersonale;
import DAO.DAODecedati;
import modelcore.TipDecedat;
import dto.DecedatDTO;
import exceptions.BusinessException;
import exceptions.ValidatorException;
//import DAO.DAODecedati;
import services.api.ServiceDecedati;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import validators.DatePersonaleValidator;
import validators.DecedatValidator;

public class ServiceDecedatiImpl implements ServiceDecedati{
	
	private DAODecedati daoDecedati;
	private DAODatePersonale daoDatePersonale;
	private DecedatValidator decedatValidator;
	private DatePersonaleValidator datePersonaleValidator;

	@Override
	public void inscrieDecedat(DecedatDTO decedatDTO) throws BusinessException {
		try{
			decedatValidator.validate(decedatDTO.getDecedat());
			datePersonaleValidator.validate(decedatDTO.getDatePersonale());
			daoDatePersonale.insert(decedatDTO.getDatePersonale());
			daoDecedati.insert(decedatDTO.getDecedat());
		} catch  (ValidatorException validatorException) {
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
	}

	@Override
	public void actualizeazaDecedat(DecedatDTO decedatDTO)
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
	public List<DecedatDTO> getDecedati(TipDecedat tipDecedat,
			String criteriuCautare, Data dataMinimaInmormantare) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	@Override
	public void stergeDecedat(DecedatDTO decedatDTO) throws BusinessException {
		try{
			daoDecedati.delete(decedatDTO.getDecedat());
			daoDatePersonale.delete(decedatDTO.getDatePersonale());
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
	}
}
