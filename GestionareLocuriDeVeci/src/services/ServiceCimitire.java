package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import domain.Cimitir;
import exceptions.BusinessException;

public interface ServiceCimitire {
	
	/**
	 * Adauga un cimitir
	 * @param cimitir
	 *     Cimitirul de adaugat
	 * @throws
	 *     BusinessException     
	 * 
	 */
	public void adaugaCimitir (Cimitir cimitir, String user) throws BusinessException;
	
	/**
	 * Sterge un cimitir
	 * @param cimitir
	 *     Cimitirul de sters
	 * @throws
	 *     BusinessException     
	 * 
	 */
	public void stergeCimitir (Cimitir cimitir, String user) throws BusinessException;
	
	/**
	 * Actualizeaza un cimitir
	 * @param cimitir
	 *     Cimitirul de actualizat
	 * @throws
	 *     BusinessException     
	 * 
	 */
	public void actualizeazaCimitir(Cimitir cimitir, String user) throws BusinessException;
	
	public List<Cimitir> getCimitire() throws BusinessException;
	

}
