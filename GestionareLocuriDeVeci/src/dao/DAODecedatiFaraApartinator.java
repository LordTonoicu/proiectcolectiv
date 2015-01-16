package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Decedat;
import domain.DecedatFaraApartinatori;
import domain.registers.InregRegAnualDeProgrInmormantari;

public class DAODecedatiFaraApartinator implements IDAODecedatiFaraAparatinator {

	private Connection connection = null;
	PreparedStatement PSInsert = null;
	PreparedStatement PSUpdate = null;
	PreparedStatement PSDelete = null;
	PreparedStatement PSSelect = null;

	public DAODecedatiFaraApartinator() {

		connection = ConnectionFactory.getConnection();
	}

	public void insert(DecedatFaraApartinatori decedat) throws SQLException {

		try {
			String insertTable = "INSERT INTO DecedatiFaraApartinatori"
					+ "(cnpDecedat, dataInmormantare, nrAdeverintaInhumare, idLocDeVeci, nrAdeverintaAsistenta, religie, deleted) VALUES"
					+ "(? ,?, ?, ?, ?, ?, false)";
			PSInsert = connection.prepareStatement(insertTable);
			PSInsert.setString(1, decedat.getCnpDecedat());
			PSInsert.setDate(2, new Date(decedat.getDataInmormantare()
					.getTime()));
			PSInsert.setInt(3, decedat.getNrAdeverintaInhumare());
			PSInsert.setInt(4, decedat.getIdLocDeVeci());
			PSInsert.setString(6, decedat.getReligie());
			
			PSInsert.setInt(5,decedat.getNrAdeverintaAsistenta());
			PSInsert.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException("Error when trying to insert the: "
					+ decedat + ":" + ex.getMessage());
		} finally {
			if (PSInsert != null) {
				PSInsert.close();
			}
		}
	}

	public void delete(DecedatFaraApartinatori decedat) throws SQLException {

		try {
			String deleteTable = "UPDATE DecedatiFaraApartinatori set deleted=true " + "WHERE idDecedat = ?";
			PSDelete = connection.prepareStatement(deleteTable);
			PSDelete.setInt(1, decedat.getIdDecedat());
			PSDelete.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException("Error when trying to delete the: "
					+ decedat + ":" + ex.getMessage());
		} finally {
			if (PSDelete != null) {
				PSDelete.close();
			}
		}
	}

	public void update(DecedatFaraApartinatori decedat) throws SQLException {

		try {
			String updateTable = "UPDATE DecedatiFaraApartinatori SET cnpDecedat = ?, dataInmormantare = ?, nrAdeverintaInhumare = ?, idLocDeVeci = ?, nrAdeverintaAsistenta = ?, religie = ? WHERE idDecedat = ?";
			PSUpdate = connection.prepareStatement(updateTable);
			PSUpdate.setInt(6, decedat.getIdDecedat());
			PSUpdate.setString(1, decedat.getCnpDecedat());
			PSUpdate.setDate(2, new Date(decedat.getDataInmormantare()
					.getTime()));
			PSUpdate.setInt(3, decedat.getNrAdeverintaInhumare());
			PSUpdate.setInt(4, decedat.getIdLocDeVeci());
			PSUpdate.setString(6, decedat.getReligie());
			PSUpdate.setInt(5, decedat.getNrAdeverintaAsistenta());
			
			PSUpdate.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException("Error when trying to update the: "
					+ decedat + ":" + ex.getMessage());
		} finally {
			if (PSUpdate != null) {
				PSUpdate.close();
			}
		}
	}

	public DecedatFaraApartinatori getByCNP(String CNP) throws SQLException {

		DecedatFaraApartinatori decedat = null;

		try {
			String selectTable = "SELECT * FROM DecedatiFaraApartinatori WHERE cnpDecedat = ?";
			PSSelect = connection.prepareStatement(selectTable);
			PSSelect.setString(1, CNP);
			ResultSet result = PSSelect.executeQuery();

			if (result.next()) {
				boolean ePersonalitate = false;
				decedat = new DecedatFaraApartinatori(result.getInt(1), CNP,
						result.getInt(3), result.getDate(4), result.getInt(5), result.getInt(6), result.getString(8));
			}

		} catch (SQLException ex) {
			throw new SQLException(
					"Error when trying to retrieve the Decedat with CNP: "
							+ CNP + ":" + ex.getMessage());
		} finally {
			if (PSSelect != null) {
				PSSelect.close();
			}
		}
		return decedat;
	}

	@Override
	public List<DecedatFaraApartinatori> getAllDecedatiFaraApartinatori() throws SQLException {
		List<DecedatFaraApartinatori> decedati = new ArrayList<DecedatFaraApartinatori>();

		try {
			String selectTable = "SELECT * FROM DecedatiFaraApartinatori";
			PSSelect = connection.prepareStatement(selectTable);
			ResultSet result = PSSelect.executeQuery(selectTable);
			DecedatFaraApartinatori decedat;

			while (result.next()) {
				decedat = new DecedatFaraApartinatori(result.getInt(1), result.getString(2),
						 result.getInt(3),result.getDate(4), result.getInt(5),
						result.getInt(6), result.getString(8));
				decedati.add(decedat);
			}

		} catch (SQLException ex) {
			throw new SQLException(
					"Error when trying to retrieve the inregistrariJurnal:"
							+ ex.getMessage());
		} finally {
			if (PSSelect != null) {
				PSSelect.close();
			}
		}
		return decedati;

	}
}
