package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import validators.DatePersonaleValidator;
import validators.DecedatValidator;
import dao.DAODatePersonale;
import dao.DAODecedati;
import domain.Decedat;
import dto.DecedatDTO;
import exceptions.BusinessException;
import exceptions.ValidatorException;
//import DAO.DAODecedati;

public class ServiceDecedatiImpl implements ServiceDecedati{
	
	private DAODecedati daoDecedati;
	private DAODatePersonale daoDatePersonale;
	private DecedatValidator decedatValidator;
	private DatePersonaleValidator datePersonaleValidator;
	
	public ServiceDecedatiImpl() {
		super();
		this.daoDecedati=new DAODecedati();
		this.decedatValidator=new DecedatValidator();
		this.daoDatePersonale = new DAODatePersonale();
	}

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
	public void stergeDecedat(DecedatDTO decedatDTO) throws BusinessException {
		try{
			daoDecedati.delete(decedatDTO.getDecedat());
			daoDatePersonale.delete(decedatDTO.getDatePersonale());
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
	}
	
	@Override
	public List<DecedatDTO> getDecedati() throws BusinessException {
		List<DecedatDTO> listDecedatiDTO = new ArrayList<DecedatDTO>();
		try {
			List<Decedat> listDecedati = daoDecedati.getAllDecedati();
			
			for(Decedat decedat: listDecedati){
				DecedatDTO decedatDTO = new DecedatDTO(decedat,daoDatePersonale.getDatePersonaleFromDecedat(decedat));
				listDecedatiDTO.add(decedatDTO);
			}
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return listDecedatiDTO;
	
	}
}
