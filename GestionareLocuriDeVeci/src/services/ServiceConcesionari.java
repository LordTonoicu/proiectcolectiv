package services;

import java.util.List;

import dto.ConcesionarDTO;
import exceptions.BusinessException;

public interface ServiceConcesionari {
	
	public void adaugaConcesionar (ConcesionarDTO concesionarDTO) throws BusinessException;
    public void actualizeazaConcesionar (ConcesionarDTO concesionarDTO) throws BusinessException;
    public void stergeConcesionar (ConcesionarDTO concesionarDTO) throws BusinessException;
    public List<ConcesionarDTO> getConcesionari() throws BusinessException;
}
