package services.impl;

import java.util.List;

import dto.LocDeVeciDTO;
import exceptions.BusinessException;
import services.api.ServiceLocuriDeVeci;


public class ServiceLocuriDeVeciImpl implements ServiceLocuriDeVeci{

	@Override
	public List<LocDeVeciDTO> getLocuriDeVeciExpirate(int anulExpirarii) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocDeVeciDTO> getLocuriDeVeciExpirate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void trimiteEmailConcesionar(int locDeVeciExpirat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LocDeVeciDTO> getLocuriDeVeciExpirandInAnulCurent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocDeVeciDTO> getLocuriDeVeciPlatiteInAnulInCurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adaugaLocDeVeci(LocDeVeciDTO locDeVeci)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizeazaLocDeVeci(LocDeVeciDTO locDeVeci)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
