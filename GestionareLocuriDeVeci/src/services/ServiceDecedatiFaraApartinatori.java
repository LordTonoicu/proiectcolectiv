package services;

import java.util.List;

import javax.xml.crypto.Data;

import domain.Decedat;
import dto.DecedatDTO;
import dto.DecedatFaraApartinatoriDTO;
import exceptions.BusinessException;

public interface ServiceDecedatiFaraApartinatori {
	
	/**
	 * 
	 * Inscrie un decedat (urmand a fi) inmormantat 
	 * @param decedat: DecedatDTO
	 *        Obiectul ingloband datele decedatului, respectiv parcela 
	 */
	/*OBSERVATIE: Datele decedatului vor fi persistate in prealabil in tab. Date personale*/
	public void inscrieDecedatFaraApartinator (DecedatFaraApartinatoriDTO decedat, String user) throws BusinessException;

	/**
	 * 
	 * Actualizeaza informatiile corespunzatoare unui decedat anterior inscris 
	 * @param decedat: DecedatDTO
	 *        Obiectul ingloband noile informatii corespunzatoare decedatului, 
	 *        respectiv (noua) parcela 
	 */
	/*OBSERVATIE: Datele decedatului vor fi actualizate (eventual) in tab. Date personale*/
	public void actualizeazaDecedatFaraApartinator (DecedatFaraApartinatoriDTO decedat, String user) throws BusinessException;
	
	/**
	 * Elimina un decesat persistat in prealabil.
	 * @param
	 *     Decedatul de eliminat
	 * @throws
	 *     BusinessException    
	 * */
	public void stergeDecedatFaraApartinator (DecedatFaraApartinatoriDTO decedatDTO, String user) throws BusinessException;
	
	
	/**
	 * Returneaza toti decedatii de un anumit tip inregistrati continand
	 * un substring in nume/prenume si inmormantati ulterior unei date 
	 * specificate
	 * 
	 * @param tipDecedat
	 *       Tipul decedatilor doriti a fi returnati
	 * @param criteriuCautare
	 *        Sirul de caractere ce se doreste a fi continut in nume-
	 *        le sau prenumele decedatilor returnati
	 * @param dataMinimaInmormantare
	 *        Data ulterior careia imnormantarea decedatilor returnati
	 *        a avut loc       
	 *        
	 *        
	 * @return
	 *       Lista continand toti decedatii inregistrati de tipul 
	 *       specificat ale caror nume sau prenume contin sirul de
	 *       caractere specificat si ale caror inmormantari au avut
	 *       loc ulterior datei mentionate
	 */
	
	/*
	 * OBSERVATIE: => GUI: posibilitatea de selectare tip decedat, data min. ca si criterii de filtrare
	 */
	
	public List<DecedatFaraApartinatoriDTO> getDecedatiFaraApartinatori() throws BusinessException;
	
	
}
