package services;

import java.util.List;

import domain.CerereInhumare;
import dto.CerereInhumareDTO;
import exceptions.BusinessException;

public interface ServiceCereriInhumare {
	public void adaugaCerereInhumare(CerereInhumare cerereInhumare, String user)
			throws BusinessException;

	public void actualizeazaCerereInhumare(CerereInhumare cerereInhumare,
			String user) throws BusinessException;

	public void stergeCerereInhumare(CerereInhumare cerereInhumare, String user)
			throws BusinessException;

	public List<CerereInhumareDTO> getCereriInhumare() throws BusinessException;

}
