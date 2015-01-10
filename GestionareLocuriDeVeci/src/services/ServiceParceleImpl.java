package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import services.util.UtilInregistrareJurnal;
import validators.ParcelaValidator;
import dao.DAOCimitire;
import dao.DAOJurnal;
import dao.DAOParcele;
import dao.IDAOCimitire;
import dao.IDAOJurnal;
import dao.IDAOParcele;
import domain.Cimitir;
import domain.Parcela;
import dto.ParcelaDTO;
import exceptions.BusinessException;
import exceptions.ValidatorException;

public class ServiceParceleImpl implements ServiceParcele{

	private ParcelaValidator parcelaValidator;
	private IDAOParcele daoParcele;
    private IDAOCimitire daoCimitire;
    private IDAOJurnal daoJurnal;
	
	public ServiceParceleImpl() {
		super();
		this.daoParcele=new DAOParcele();
		this.parcelaValidator=new ParcelaValidator();
		this.daoCimitire = new DAOCimitire();
		this.daoJurnal = new DAOJurnal();
	}

	public ServiceParceleImpl(ParcelaValidator parcelaValidator,
			DAOParcele daoParcele, DAOCimitire daoCimitire) {
		super();
		this.parcelaValidator = parcelaValidator;
		this.daoParcele = daoParcele;
		this.daoCimitire = daoCimitire;
	}

	public void setParcelaValidator(ParcelaValidator parcelaValidator) {
		this.parcelaValidator = parcelaValidator;
	}

	public void setDaoParcele(DAOParcele daoParcele) {
		this.daoParcele = daoParcele;
	}
	
	public void setDaoCimitire(DAOCimitire daoCimitire) {
		this.daoCimitire = daoCimitire;
	}

	@Override
	public void adaugaParcela(Parcela parcela, String user) throws BusinessException {
		try {
			parcelaValidator.validate(parcela);
			daoParcele.insert(parcela);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "adaugare", parcela.toString()));
		} catch (ValidatorException validatorException){
			throw new BusinessException(validatorException.getMessage());
		} catch (SQLException sqlException){
			     //La nivelul DAO ar trebui sa se arunce o exceptie mai generica (DataAccessException)
			throw new BusinessException(sqlException.getMessage());
		}
		
	}

	@Override
	public void stergeParcela(Parcela parcela, String user) throws BusinessException {
		try {
			daoParcele.delete(parcela);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "stergere", parcela.toString()));
		} catch (SQLException sqlException){
			 throw new BusinessException(sqlException.getMessage());
		}
	}

	@Override
	public void actualizeazaParcela(Parcela parcela, String user) throws BusinessException {
		try {
			parcelaValidator.validate(parcela);
			Parcela anterior = daoParcele.getById(parcela.getIdParcela());
			daoParcele.update(parcela);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "actualizare", anterior.toString(), parcela.toString()));
		} catch (ValidatorException validatorException){
			throw new BusinessException(validatorException.getMessage());
		} catch (SQLException sqlException){
			throw new BusinessException(sqlException.getMessage());
		}
	}
	@Override
	public List<ParcelaDTO> getParcele() throws BusinessException {
		List<ParcelaDTO> parceleDTOs = new ArrayList<ParcelaDTO>();
		try {
			List<Parcela> parcele = daoParcele.getAllParcele();
			for (Parcela parcela: parcele){
				ParcelaDTO parcelaDTO = new ParcelaDTO();
				
				parcelaDTO.setParcela(parcela);
				System.out.println(String.valueOf(parcela.getIdCimitir()));
				Cimitir c = daoCimitire.getById(parcela.getIdCimitir());
		        parcelaDTO.setDenumireCimitir(c.getDenumire());
		        
		        parceleDTOs.add(parcelaDTO);
			}
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
	    return parceleDTOs; 
	}
	
	@Override
	public List<ParcelaDTO> getParceleByIdCimitir(int idCimitir)
			throws BusinessException {
		List<ParcelaDTO> raspuns = new ArrayList<ParcelaDTO>();
		try {
			String denumireCimitir  = daoCimitire.getById(idCimitir).getDenumire();
			List<Parcela> parcele = daoParcele.getAllParcele();
			for (Parcela parcela: parcele){
				if (parcela.getIdCimitir() == idCimitir){
					ParcelaDTO parcelaDTO = new ParcelaDTO();
					parcelaDTO.setParcela(parcela);
					parcelaDTO.setDenumireCimitir(denumireCimitir);
					raspuns.add(parcelaDTO);
				}
			}
		} catch (SQLException sqlException) {
			throw new BusinessException(sqlException.getMessage());
		}
		return raspuns;
	}
}
