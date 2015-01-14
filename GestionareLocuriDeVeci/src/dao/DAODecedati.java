package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Decedat;

public class DAODecedati implements IDAODecedati {

	private Connection connection = null;
	PreparedStatement PSInsert = null;
	PreparedStatement PSUpdate = null;
	PreparedStatement PSDelete = null;
	PreparedStatement PSSelect = null;

	public DAODecedati() {

		connection = ConnectionFactory.getConnection();
	}

	public void insert(Decedat decedat) throws SQLException {

		try {
			String insertTable = "INSERT INTO Decedati"
					+ "(cnpDecedat, dataInmormantare, nrAdeverintaInhumare, idLocDeVeci, ePersonalitate) VALUES"
					+ "(? , ?, ?, ?, ?)";
			PSInsert = connection.prepareStatement(insertTable);
			PSInsert.setString(1, decedat.getCnpDecedat());
			PSInsert.setDate(2, new Date(decedat.getDataInmormantare()
					.getTime()));
			PSInsert.setInt(3, decedat.getNrAdeverintaInhumare());
			PSInsert.setInt(4, decedat.getIdLocDeVeci());
			if (decedat.isePersonalitate() == true) {
				PSInsert.setInt(5, 1);
			} else {
				PSInsert.setInt(5, 0);
			}
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

	public void delete(Decedat decedat) throws SQLException {

		try {
			String deleteTable = "DELETE FROM Decedati "
					+ "WHERE idDecedat = ?";
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

	public void update(Decedat decedat) throws SQLException {

		try {
			String updateTable = "UPDATE Decedati SET cnpDecedat = ?, dataInmormantare = ?, nrAdeverintaInhumare = ?, idLocDeVeci = ?, ePersonalitate = ? WHERE idDecedat = ?";
			PSUpdate = connection.prepareStatement(updateTable);
			PSUpdate.setInt(6, decedat.getIdDecedat());
			PSUpdate.setString(1, decedat.getCnpDecedat());
			PSUpdate.setDate(2, new Date(decedat.getDataInmormantare()
					.getTime()));
			PSUpdate.setInt(3, decedat.getNrAdeverintaInhumare());
			PSUpdate.setInt(4, decedat.getIdLocDeVeci());
			if (decedat.isePersonalitate() == true) {
				System.out.println("perso");
				PSUpdate.setInt(5, 1);
			} else {
				System.out.println("nu");
				PSUpdate.setInt(5, 0);
			}
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

	public Decedat getByCNP(String CNP) throws SQLException {

		Decedat decedat = null;

		try {
			String selectTable = "SELECT * FROM Decedati WHERE cnpDecedat = ?";
			PSSelect = connection.prepareStatement(selectTable);
			PSSelect.setString(1, CNP);
			ResultSet result = PSSelect.executeQuery();

			if (result.next()) {
				boolean ePersonalitate = false;
				if (result.getInt(6) == 1) {
					ePersonalitate = true;
				}
				decedat = new Decedat(result.getInt(1), CNP, result.getDate(3),
						result.getInt(4), result.getInt(5), ePersonalitate);
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
	public List<Decedat> getAllDecedati() throws SQLException {
		List<Decedat> decedati = new ArrayList<Decedat>();

		try {
			String selectTable = "SELECT * FROM Decedati";
			PSSelect = connection.prepareStatement(selectTable);
			ResultSet result = PSSelect.executeQuery(selectTable);
			Decedat decedat;

			while (result.next()) {
				decedat = new Decedat(result.getInt(1), result.getString(2),
						result.getDate(3), result.getInt(4), result.getInt(5),
						result.getBoolean(6));
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
