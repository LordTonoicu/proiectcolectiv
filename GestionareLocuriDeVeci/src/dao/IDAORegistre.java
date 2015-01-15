package dao;

import java.sql.SQLException;
import java.util.List;

import domain.registers.InregRegAnualDeProgrInmormantari;

public interface IDAORegistre {

	public List<InregRegAnualDeProgrInmormantari> getRegAnualDeProgramareAInmormantarilor() throws SQLException;
}
