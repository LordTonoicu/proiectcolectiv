package dao;

import java.sql.SQLException;
import java.util.List;

import domain.registers.InregRegAnualDeProgrInmormantari;
import domain.registers.InregRegAnualDecedati;
import domain.registers.InregRegCereriInhumare;
import domain.registers.InregRegContracteConcesiune;
import domain.registers.InregRegDeMorminte;
import domain.registers.InregRegDecedatiFaraApartinatori;
import domain.registers.InregRegMorminteMonFunerareVal;

public class DAORegistre implements IDAORegistre{

	@Override
	public List<InregRegAnualDeProgrInmormantari> getRegAnualDeProgramareAInmormantarilor()
			throws SQLException {
		// TODO Auto-generated method stub
				return null;
	}

	@Override
	public List<InregRegDeMorminte> getRegDeMorminte() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InregRegMorminteMonFunerareVal> getRegDeMorminteMonFunerare()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InregRegAnualDecedati> getRegAnualDecedati()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InregRegDecedatiFaraApartinatori> getRegAnualDecedatiFaraApartinatori()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InregRegCereriInhumare> getRegCereriInhumare()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InregRegContracteConcesiune> getRegContracteConcesiune()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
