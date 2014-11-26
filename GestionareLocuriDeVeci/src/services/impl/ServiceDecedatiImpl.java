package services.impl;

import java.util.List;

import javax.xml.crypto.Data;

import modelcore.TipDecedat;
import dto.DecedatDTO;
import exceptions.BusinessException;
//import DAO.DAODecedati;
import services.api.ServiceDecedati;

public class ServiceDecedatiImpl implements ServiceDecedati{
	
	//private DAODecedati daoDecedati;

	@Override
	public void inscrieDecedat(DecedatDTO decedat) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizeazaDecedat(DecedatDTO decedat)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DecedatDTO> getDecedati(TipDecedat tipDecedat,
			String criteriuCautare, Data dataMinimaInmormantare) {
		// TODO Auto-generated method stub
		return null;
	}


}
