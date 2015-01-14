package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CerereInhumare;
import domain.ContractConcesiune;

public class DAOCereriInhumare implements IDAOCereriInhumare {
	private Connection connection = null;
	PreparedStatement PSInsert = null;
	PreparedStatement PSUpdate = null;
	PreparedStatement PSDelete = null;
	PreparedStatement PSSelect = null;

	public DAOCereriInhumare() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void insert(CerereInhumare cerereInhumare) throws SQLException {
		try {
			String insertTable = "INSERT INTO CereriInhumare (nrCerere, dataInregistrare, stadiuSolutionare, cnpConcesionar) VALUES"
					+ "(? , ?, ? ,?)";
			PSInsert = connection.prepareStatement(insertTable);
			PSInsert.setInt(1, cerereInhumare.getNrCerere());
			PSInsert.setDate(2, cerereInhumare.getDataInregistrare());
			PSInsert.setString(3, cerereInhumare.getStadiuSolutionare());
			PSInsert.setString(4, cerereInhumare.getCnpConcesionar());
			PSInsert.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException("Error when trying to insert the: "
					+ cerereInhumare + ":" + ex.getMessage());
		} finally {
			if (PSInsert != null) {
				PSInsert.close();
			}
		}

	}

	@Override
	public void update(CerereInhumare cerereInhumare) throws SQLException {
		try {
			String updateTable = "UPDATE CereriInhumare SET nrCerere = ?, dataInregistrare= ?, stadiuSolutionare=?, cnpConcesionar = ? WHERE nrCerere = ?";
			PSUpdate = connection.prepareStatement(updateTable);
			PSUpdate.setInt(1, cerereInhumare.getNrCerere());
			PSUpdate.setDate(2, cerereInhumare.getDataInregistrare());
			PSUpdate.setString(3, cerereInhumare.getStadiuSolutionare());
			PSUpdate.setString(4, cerereInhumare.getCnpConcesionar());
			PSUpdate.setInt(5, cerereInhumare.getNrCerere());
			PSUpdate.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException("Error when trying to update the: "
					+ cerereInhumare + ":" + ex.getMessage());
		} finally {
			if (PSUpdate != null) {
				PSUpdate.close();
			}
		}

	}

	@Override
	public void delete(CerereInhumare cerereInhumare) throws SQLException {
		try {
			String deleteTable = "UPDATE  CereriInhumare SET deleted=true "
					+ "WHERE nrCerere = ?";
			PSDelete = connection.prepareStatement(deleteTable);
			PSDelete.setInt(1, cerereInhumare.getNrCerere());
			PSDelete.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException("Error when trying to delete the: "
					+ cerereInhumare + ":" + ex.getMessage());
		} finally {
			if (PSDelete != null) {
				PSDelete.close();
			}
		}

	}

	@Override
	public List<CerereInhumare> getAll() throws SQLException {
		List<CerereInhumare> cereriInhumare = new ArrayList<CerereInhumare>();

		try{
			String selectTable = "SELECT * FROM CereriInhumare WHERE deleted=false";
			PSSelect = connection.prepareStatement(selectTable);

			ResultSet result = PSSelect.executeQuery(selectTable);
			CerereInhumare ci; 

			while(result.next()) {
				ci = new CerereInhumare(result.getInt(1),result.getDate(2),result.getString(3),result.getString(4));
				cereriInhumare.add(ci);
			}

		}catch(SQLException ex) {
			throw new SQLException("Error when trying to retrieve cereri inhumare: " + ex.getMessage());
		}finally{
			if(PSSelect !=null){
				PSSelect.close();
			}
		}
		return cereriInhumare;
	}

	@Override
	public CerereInhumare getByNrCerere(int nrCerere) throws SQLException {
		CerereInhumare ci=null;
		try{

			String selectTable = "SELECT * FROM CereriInhumare WHERE nrCerere = " + String.valueOf(nrCerere);
			PSSelect = connection.prepareStatement(selectTable);

			ResultSet result = PSSelect.executeQuery(selectTable);


			while(result.next()) {
				ci = new CerereInhumare(result.getInt(1),result.getDate(2),result.getString(3),result.getString(4));

			}

		}catch(SQLException ex) {
			throw new SQLException("Error when trying to retrieve the CerereInhumare:" + ex.getMessage());
		}finally{
			if(PSSelect !=null){
				PSSelect.close();
			}
		}
		return ci;	}

}
