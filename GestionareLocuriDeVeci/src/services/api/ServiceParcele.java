package services.api;

import Domain.Parcela;
import exceptions.BusinessException;

public interface ServiceParcele {
	/**
	 * Adauga o parcela
	 * @param parcela
	 *     Parcela de adaugat
	 * @throws
	 *     BusinessException     
	 * 
	 */
	public void adaugaParcela (Parcela parcela) throws BusinessException;
	
	/**
	 * Sterge o parcela
	 * @param parcela
	 *     Parcela de sters
	 * @throws
	 *     BusinessException     
	 * 
	 */
	public void stergeParcela (Parcela parcela) throws BusinessException;
	
	/**
	 * Actualizeaza o parcela
	 * @param parcela
	 *     Parcela de actualizat
	 * @throws
	 *     BusinessException     
	 * 
	 */
	public void actualizeazaParcela(Parcela parcela) throws BusinessException;
	
}
