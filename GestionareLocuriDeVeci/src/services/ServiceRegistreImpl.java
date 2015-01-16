package services;

import java.sql.SQLException;
import java.util.List;

import dao.DAORegistre;
import dao.IDAORegistre;
import domain.registers.InregRegAnualDeProgrInmormantari;
import domain.registers.InregRegAnualDecedati;
import domain.registers.InregRegCereriInhumare;
import domain.registers.InregRegContracteConcesiune;
import domain.registers.InregRegDeMorminte;
import domain.registers.InregRegDecedatiFaraApartinatori;
import domain.registers.InregRegMorminteMonFunerareVal;
import exceptions.BusinessException;

public class ServiceRegistreImpl implements ServiceRegistre{

	private IDAORegistre DAORegistre;	

	public  ServiceRegistreImpl() {
		this.DAORegistre = new DAORegistre();
	}

	public void setDAORegistre(IDAORegistre dAORegistre) {
		DAORegistre = dAORegistre;
	}

	@Override
	public List<InregRegAnualDeProgrInmormantari> getRegAnualDeProgramareAInmormantarilor() throws BusinessException {
		List<InregRegAnualDeProgrInmormantari> registru = null;
		try{
			registru  = DAORegistre.getRegAnualDeProgramareAInmormantarilor();
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegDeMorminte> getRegDeMorminte() throws BusinessException {
		List<InregRegDeMorminte> registru = null;
		try{
			registru = DAORegistre.getRegDeMorminte();
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegMorminteMonFunerareVal> getRegDeMorminteMonFunerare()
			throws BusinessException {
		List<InregRegMorminteMonFunerareVal> registru = null;
		try{
			registru = DAORegistre.getRegDeMorminteMonFunerare();
		}catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegAnualDecedati> getRegAnualDecedati()
			throws BusinessException {
		List<InregRegAnualDecedati> registru = null;
		try{
			registru = DAORegistre.getRegAnualDecedati();
		}catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegDecedatiFaraApartinatori> getRegAnualDecedatiFaraApartinatori()
			throws BusinessException {
		List<InregRegDecedatiFaraApartinatori> registru = null;
		try{
			registru = DAORegistre.getRegAnualDecedatiFaraApartinatori();
		}catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegCereriInhumare> getRegCereriInhumare()
			throws BusinessException {
		List<InregRegCereriInhumare> registru = null;
		try{
			registru = DAORegistre.getRegCereriInhumare();
		}catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegContracteConcesiune> getRegContracteConcesiune()
			throws BusinessException {
		List<InregRegContracteConcesiune> registru = null;
		try{
			registru = DAORegistre.getRegContracteConcesiune();
		}catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegDeMorminte> getByParcelaAndNrLoc(String parcela,int nrLocDeVeci)
			throws BusinessException {
		List<InregRegDeMorminte> registru = null;
		try{
			registru = DAORegistre.getByParcelaAndNrLoc(parcela, nrLocDeVeci);
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return registru;
	}

}
