package services;

import java.sql.SQLException;
import java.util.List;

import domain.registers.InregRegAnualDeProgrInmormantari;
import exceptions.BusinessException;

public interface ServiceRegistre {
	
	public List<InregRegAnualDeProgrInmormantari> getRegAnualDeProgramareAInmormantarilor() throws BusinessException;
}
