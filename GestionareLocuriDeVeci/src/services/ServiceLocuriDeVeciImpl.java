package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.smartcardio.ATR;

import validators.LocDeVeciValidator;
import dao.DAOCimitire;
import dao.DAOLocuri;
import dao.IDAOCimitire;
import dao.IDAOLocuri;
import dao.IDAOParcele;
import domain.LocDeVeci;
import dto.LocDeVeciDTO;
import dto.ParcelaDTO;
import exceptions.BusinessException;
import exceptions.ValidatorException;

public class ServiceLocuriDeVeciImpl implements ServiceLocuriDeVeci {

	private IDAOLocuri daoLocuri;
	private IDAOParcele daoParcele;
	private LocDeVeciValidator locDeVeciValidator;

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
	}

	@Override
	public void trimiteEmailConcesionar(int locDeVeciExpirat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void adaugaLocDeVeci(LocDeVeci locDeVeci) throws BusinessException {
		try {
			locDeVeciValidator.validate(locDeVeci);
			daoLocuri.insert(locDeVeci);
		} catch (ValidatorException validatorException) {
			throw new BusinessException("Validation exception: "
					+ validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: "
					+ sqlException.getMessage());
		}
	}

	@Override
	public void actualizeazaLocDeVeci(LocDeVeci locDeVeci)
			throws BusinessException {
		try {
			locDeVeciValidator.validate(locDeVeci);
			daoLocuri.update(locDeVeci);
		} catch (ValidatorException validatorException) {
			throw new BusinessException("Validation exception: "
					+ validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: "
					+ sqlException.getMessage());
		}

	}

	@Override
	public void stergeLocDeVeci(LocDeVeci locDeVeci) throws BusinessException {
		try {
			daoLocuri.delete(locDeVeci);
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: "
					+ sqlException.getMessage());
		}
	}

	@Override
	public List<LocDeVeci> getLocuriDeVeciExpirate(int anulExpirarii) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocDeVeci> getLocuriDeVeciExpirate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocDeVeci> getLocuriDeVeciExpirandInAnulCurent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocDeVeci> getLocuriDeVeciPlatiteInAnulInCurs() {
		// TODO Auto-generated method stub
		return null;
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
}
