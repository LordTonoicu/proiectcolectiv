package services.api;

import java.util.List;

import exceptions.BusinessException;
import Domain.Cimitir;

public interface ServiceCimitire {
	
	/**
	 * Adauga un cimitir
	 * @param cimitir
	 *     Cimitirul de adaugat
	 * @throws
	 *     BusinessException     
	 * 
	 */
	public void adaugaCimitir (Cimitir cimitir) throws BusinessException;
	
	/**
	 * Sterge un cimitir
	 * @param cimitir
	 *     Cimitirul de sters
	 * @throws
	 *     BusinessException     
	 * 
	 */
	public void stergeCimitir (Cimitir cimitir) throws BusinessException;
	
	/**
	 * Actualizeaza un cimitir
	 * @param cimitir
	 *     Cimitirul de actualizat
	 * @throws
	 *     BusinessException     
	 * 
	 */
	public void actualizeazaCimitir(Cimitir cimitir) throws BusinessException;
	
	public List<Cimitir> getCimitire() throws BusinessException;
	

}
