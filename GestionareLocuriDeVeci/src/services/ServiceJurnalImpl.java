package services;

import java.sql.SQLException;
import java.util.List;

import dao.DAOJurnal;
import domain.InregistrareJurnal;
import exceptions.BusinessException;

public class ServiceJurnalImpl implements ServiceJurnal{
	
	private DAOJurnal daoJurnal;

    public ServiceJurnalImpl() {
		this.daoJurnal = new DAOJurnal();
	}
	
	@Override
	public List<InregistrareJurnal> getJurnal() throws BusinessException{
		List<InregistrareJurnal> result = null;
		try {
			result =  daoJurnal.getAll();
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage());
		}
		return result;
	}
}
