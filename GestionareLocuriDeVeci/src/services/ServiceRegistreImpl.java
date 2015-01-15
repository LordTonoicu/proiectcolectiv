package services;

import java.sql.SQLException;
import java.util.List;

import dao.DAORegistre;
import dao.IDAORegistre;
import domain.registers.InregRegAnualDeProgrInmormantari;
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

}
