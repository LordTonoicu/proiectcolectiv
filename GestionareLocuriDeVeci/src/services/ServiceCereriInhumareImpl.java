package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import services.util.UtilInregistrareJurnal;
import validators.CerereInhumareValidator;
import dao.DAOCereriInhumare;
import dao.DAOConcesionari;
import dao.DAODatePersonale;
import dao.DAOJurnal;
import dao.IDAOCereriInhumare;
import dao.IDAOConcesionari;
import dao.IDAODatePersonale;
import dao.IDAOJurnal;
import domain.CerereInhumare;
import domain.Concesionar;
import domain.DatePersonale;
import dto.CerereInhumareDTO;
import dto.ConcesionarDTO;
import exceptions.BusinessException;
import exceptions.ValidatorException;

public class ServiceCereriInhumareImpl implements ServiceCereriInhumare {
	private CerereInhumareValidator validator;
	private IDAOCereriInhumare daoCereriInhumare;
	private IDAOJurnal daoJurnal;
	private IDAOConcesionari daoConcesionari;
	private IDAODatePersonale daoDatePersonale;

	public ServiceCereriInhumareImpl() {
		super();
		this.validator = new CerereInhumareValidator();
		this.daoCereriInhumare = new DAOCereriInhumare();
		this.daoConcesionari = new DAOConcesionari();
		this.daoDatePersonale = new DAODatePersonale();
		this.daoJurnal = new DAOJurnal();
	}

	public ServiceCereriInhumareImpl(CerereInhumareValidator validator,
			IDAOCereriInhumare daoCereriInhumare, IDAOJurnal daoJurnal,
			IDAOConcesionari daoConcesionari, IDAODatePersonale daoDatePersonale) {
		super();
		this.validator = validator;
		this.daoCereriInhumare = daoCereriInhumare;
		this.daoJurnal = daoJurnal;
		this.daoConcesionari = daoConcesionari;
		this.daoDatePersonale = daoDatePersonale;
	}



	@Override
	public void adaugaCerereInhumare(CerereInhumare cerereInhumare, String user)
			throws BusinessException {
		try {
			validator.validate(cerereInhumare);
			daoCereriInhumare.insert(cerereInhumare);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(
					user, "adaugare", cerereInhumare.toString()));

		} catch (ValidatorException validatorException) {
			throw new BusinessException("Validation exception: "
					+ validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: "
					+ sqlException.getMessage());
		}

	}

	@Override
	public void actualizeazaCerereInhumare(CerereInhumare cerereInhumare,
			String user) throws BusinessException {
		try{
			validator.validate(cerereInhumare);
			CerereInhumare anterioara = daoCereriInhumare.getByNrCerere(cerereInhumare.getNrCerere());
			daoCereriInhumare.update(cerereInhumare);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "actualizare", anterioara.toString(), cerereInhumare.toString()));
		} catch  (ValidatorException validatorException) {
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
	}

	@Override
	public void stergeCerereInhumare(CerereInhumare cerereInhumare, String user) throws BusinessException {
		try{
			daoCereriInhumare.delete(cerereInhumare);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "stergere", cerereInhumare.toString()));
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
	}

	@Override
	public List<CerereInhumareDTO> getCereriInhumare() throws BusinessException {
		List<CerereInhumareDTO> rezultat = null;
		try {
			List<CerereInhumare> cereriInhumare = daoCereriInhumare.getAll();
			rezultat = new ArrayList<CerereInhumareDTO>();
			for (CerereInhumare cerere : cereriInhumare) {
				CerereInhumareDTO cerereDTO = new CerereInhumareDTO();
				cerereDTO.setCerereInhumare(cerere);
				
				ConcesionarDTO concesionarDTO = new ConcesionarDTO();
				Concesionar concesionar = daoConcesionari
						.getConcesionarFromCNP(cerere.getCnpConcesionar());
				concesionarDTO.setConcesionar(concesionar);
				DatePersonale datePersonale = daoDatePersonale
						.getDatePersonaleFromCNP(cerere.getCnpConcesionar());
				concesionarDTO.setDatePersonale(datePersonale);
				
				cerereDTO.setConcesionarDTO(concesionarDTO);
				rezultat.add(cerereDTO);
			}
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: "
					+ sqlException.getMessage());
		}
		return rezultat;
	}

}
