package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import services.util.UtilInregistrareJurnal;
import validators.ContractConcesiuneValidator;
import dao.DAOConcesionari;
import dao.DAOContracteConcesiune;
import dao.DAODatePersonale;
import dao.DAOJurnal;
import domain.Concesionar;
import domain.ContractConcesiune;
import domain.DatePersonale;
import dto.ConcesionarDTO;
import dto.ContractConcesiuneDTO;
import exceptions.BusinessException;
import exceptions.ValidatorException;

public class ServiceContracteConcesiuneImpl implements ServiceContracteConcesiune{

	private ContractConcesiuneValidator validator;
	private DAOContracteConcesiune daoContracteConcesiune;
	private DAOConcesionari     daoConcesionar;
	private DAODatePersonale   daoDatePersonale;
	private DAOJurnal          daoJurnal;
	
	public ServiceContracteConcesiuneImpl() {
		this.validator = new ContractConcesiuneValidator();
		this.daoContracteConcesiune = new DAOContracteConcesiune();
		this.daoConcesionar = new DAOConcesionari();
		this.daoDatePersonale = new DAODatePersonale();
		this.daoJurnal = new DAOJurnal();
	}
	
	@Override
	public void adaugaContractConcesiune(ContractConcesiune contractConcesiune,String user)
			throws BusinessException {
		try{
			validator.validate(contractConcesiune);
			daoContracteConcesiune.insert(contractConcesiune);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "adaugare",contractConcesiune.toString()));
		} catch (ValidatorException validatorException){
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
			
	}

	@Override
	public void stergeContractConcesiune(ContractConcesiune contractConcesiune,String user)
			throws BusinessException {
		
		try{
			daoContracteConcesiune.delete(contractConcesiune);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "stergere", contractConcesiune.toString()));
		} catch (SQLException sqlException){
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}

	@Override
	public void actualizeazaContractConcesiune(
			ContractConcesiune contractConcesiune,String user) throws BusinessException {
		try{
			validator.validate(contractConcesiune);
			ContractConcesiune anterior = daoContracteConcesiune.getByNumarContract(contractConcesiune.getNrContract());
			daoContracteConcesiune.update(contractConcesiune);
			daoJurnal.insert(UtilInregistrareJurnal.creeazaInregistrareJurnal(user, "actualizare", anterior.toString(), contractConcesiune.toString()));
		} catch (ValidatorException validatorException){
			throw new BusinessException("Validation exception: " + validatorException.getMessage());
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		
	}

	@Override
	public List<ContractConcesiuneDTO> getContracteConcesiune()
			throws BusinessException {
		List<ContractConcesiuneDTO> result = null;
		List<ContractConcesiune> listContracte = null;
		 System.out.println("bla1");
		try{
			   listContracte = daoContracteConcesiune.getAll();
			   
			
			   result = new ArrayList<ContractConcesiuneDTO>();
			   for (ContractConcesiune contract: listContracte){
				   System.out.println("bla2");
				   ContractConcesiuneDTO contractConcesiuneDTO = new ContractConcesiuneDTO();
				   ConcesionarDTO concesionarDTO1 = new ConcesionarDTO();
				   ConcesionarDTO concesionarDTO2 = new ConcesionarDTO();
				   
				   concesionarDTO1.setDatePersonale(daoDatePersonale.getDatePersonaleFromCNP(contract.getCnpConcesionar1()));
				   concesionarDTO1.setConcesionar(daoConcesionar.getConcesionarFromCNP(contract.getCnpConcesionar1()));
				   concesionarDTO2.setConcesionar(daoConcesionar.getConcesionarFromCNP(contract.getCnpConcesionar2()));
				   concesionarDTO2.setDatePersonale(daoDatePersonale.getDatePersonaleFromCNP(contract.getCnpConcesionar2()));
				   
				   contractConcesiuneDTO.setContractConcesiune(contract);
				   contractConcesiuneDTO.setConcesionar1(concesionarDTO1);
				   contractConcesiuneDTO.setConcesionar2(concesionarDTO2);
				   result.add(contractConcesiuneDTO);
			   }
		} catch (SQLException sqlException) {
			throw new BusinessException("Data access exception: " + sqlException.getMessage());
		}
		return result;
	}

}
