package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import domain.Decedat;
import domain.LocDeVeci;

public class DAOLocuri implements IDAOLocuri {

	private Connection connection = null;
	PreparedStatement PSInsert = null;
	PreparedStatement PSUpdate = null;
	PreparedStatement PSSelect = null;

	public DAOLocuri() {

		connection = ConnectionFactory.getConnection();
	}

	public void insert(LocDeVeci locDeVeci) throws SQLException {

		try {
			String insertTable = "INSERT INTO locurideveci"
					+ "(suprafata,idParcela,numar,poza,isMonument,idCimitir) VALUES"
					+ "(? , ?, ?, ?, ?, ?)";
			PSInsert = connection.prepareStatement(insertTable);
			PSInsert.setInt(1, locDeVeci.getSuprafata());
			PSInsert.setInt(2, locDeVeci.getIdParcela());
			PSInsert.setInt(3, locDeVeci.getNumar());
			Blob b1 = new SerialBlob(locDeVeci.getPoza());
			PSInsert.setBlob(4, b1);
			if (locDeVeci.isMonument() == true) {
				PSInsert.setInt(5, 1);
			} else {
				PSInsert.setInt(5, 0);
			}
			PSInsert.setInt(6, locDeVeci.getIdCimitir());
			PSInsert.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException("Error when trying to insert the: "
					+ locDeVeci + ":" + ex.getMessage());
		} finally {
			if (PSInsert != null) {
				PSInsert.close();
			}
		}
	}

	public void update(LocDeVeci locDeVeci) throws SQLException {

		try {
			String updateTable = "UPDATE locurideveci SET suprafata = ?, idParcela = ?,numar = ?, poza = ?, isMonument = ?, idCimitir = ?) WHERE idLoc = ?";
			PSUpdate = connection.prepareStatement(updateTable);
			PSUpdate.setInt(7, locDeVeci.getIdLoc());
			PSUpdate.setInt(1, locDeVeci.getSuprafata());
			PSUpdate.setInt(2, locDeVeci.getIdParcela());
			PSUpdate.setInt(3, locDeVeci.getNumar());
			Blob b1 = connection.createBlob();
			b1.setBytes(0, locDeVeci.getPoza());
			PSInsert.setBlob(4, b1);
			if (locDeVeci.isMonument() == true) {
				PSUpdate.setInt(5, 1);
			} else {
				PSUpdate.setInt(5, 0);
			}
			PSUpdate.setInt(6, locDeVeci.getIdCimitir());
			PSUpdate.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException("Error when trying to update the: "
					+ locDeVeci + ":" + ex.getMessage());
		} finally {
			if (PSUpdate != null) {
				PSUpdate.close();
			}
		}
	}

	public void delete(LocDeVeci locDeVeci) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<LocDeVeci> getAll() {
		List<LocDeVeci> locuri = new ArrayList<LocDeVeci>();

		try {
			String selectTable = "SELECT * FROM LocuriDeVeci";
			PSSelect = connection.prepareStatement(selectTable);
			ResultSet result = PSSelect.executeQuery(selectTable);
			LocDeVeci loc;

			while (result.next()) {
				loc = new LocDeVeci(result.getInt(1), result.getInt(2),
						result.getInt(3), result.getInt(4), result.getBytes(5),
						result.getBoolean(6), result.getInt(7));
				locuri.add(loc);
			}

		} catch (SQLException ex) {
			try {
				throw new SQLException("Error when trying to retrieve the :"
						+ ex.getMessage());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			if (PSSelect != null) {
				try {
					PSSelect.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return locuri;
	}
}
