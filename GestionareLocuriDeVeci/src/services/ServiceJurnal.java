package services;

import java.util.List;

import domain.InregistrareJurnal;
import exceptions.BusinessException;

public interface ServiceJurnal {
	
	public List<InregistrareJurnal> getJurnal() throws BusinessException;

}
