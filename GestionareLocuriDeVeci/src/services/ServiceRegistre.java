package services;

import java.util.List;

import domain.registers.InregRegAnualDeProgrInmormantari;
import domain.registers.InregRegAnualDecedati;
import domain.registers.InregRegCereriInhumare;
import domain.registers.InregRegContracteConcesiune;
import domain.registers.InregRegDeMorminte;
import domain.registers.InregRegDecedatiFaraApartinatori;
import domain.registers.InregRegMorminteMonFunerareVal;
import exceptions.BusinessException;

public interface ServiceRegistre {
	
	public List<InregRegAnualDeProgrInmormantari> getRegAnualDeProgramareAInmormantarilor() throws BusinessException;
	public List<InregRegDeMorminte> getRegDeMorminte()  throws BusinessException;
	public List<InregRegMorminteMonFunerareVal> getRegDeMorminteMonFunerare()  throws BusinessException;
	public List<InregRegAnualDecedati> getRegAnualDecedati()  throws BusinessException;
	public List<InregRegDecedatiFaraApartinatori> getRegAnualDecedatiFaraApartinatori()  throws BusinessException;
	public List<InregRegCereriInhumare> getRegCereriInhumare()  throws BusinessException;
	public List<InregRegContracteConcesiune> getRegContracteConcesiune()  throws BusinessException;
	
}
