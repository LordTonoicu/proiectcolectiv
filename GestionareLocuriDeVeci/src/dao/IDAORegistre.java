package dao;

import java.sql.SQLException;
import java.util.List;

import domain.registers.*;

public interface IDAORegistre {

	public List<InregRegAnualDeProgrInmormantari> getRegAnualDeProgramareAInmormantarilor() throws SQLException;
	public List<InregRegDeMorminte> getRegDeMorminte() throws SQLException;
	public List<InregRegMorminteMonFunerareVal> getRegDeMorminteMonFunerare() throws SQLException;
	public List<InregRegAnualDecedati> getRegAnualDecedati() throws SQLException;
	public List<InregRegDecedatiFaraApartinatori> getRegAnualDecedatiFaraApartinatori() throws SQLException;
	public List<InregRegCereriInhumare> getRegCereriInhumare() throws SQLException;
	public List<InregRegContracteConcesiune> getRegContracteConcesiune() throws SQLException;
	
}
