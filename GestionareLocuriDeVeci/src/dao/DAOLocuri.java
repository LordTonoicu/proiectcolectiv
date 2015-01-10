package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import domain.Cimitir;
import domain.Decedat;
import domain.LocDeVeci;

public class DAOLocuri implements IDAOLocuri {

	private Connection connection = null;
	PreparedStatement PSInsert = null;
	PreparedStatement PSUpdate = null;
	PreparedStatement PSSelect = null;
	private PreparedStatement PSDelete = null;

	public DAOLocuri() {

		connection = ConnectionFactory.getConnection();
	}

	public void insert(LocDeVeci locDeVeci) throws SQLException {

		try {
			String insertTable = "INSERT INTO LocuriDeVeci"
					+ "(suprafata,idParcela,numar,poza,isMonument,idCimitir,nrContractConcesiune,deleted) VALUES"
					+ "(? , ?, ?, ?, ?, ?,0,false)";
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
			String updateTable = "UPDATE LocuriDeVeci SET suprafata = ?, idParcela = ?,numar = ?, poza = ?, isMonument = ?, idCimitir = ?, nrContractConcesiune=? WHERE idLoc = ?";
			PSUpdate = connection.prepareStatement(updateTable);
			PSUpdate.setInt(8, locDeVeci.getIdLoc());
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
			PSUpdate.setInt(7, locDeVeci.getNrContractConcesionare());
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

	public void delete(LocDeVeci locDeVeci) throws SQLException{
		try{
		       String deleteTable = "UPDATE LocuriDeVeci set deleted=true " + "WHERE idLoc = ?";
		       PSDelete = connection.prepareStatement(deleteTable);
		       PSDelete.setInt(1, locDeVeci.getIdLoc());
		       PSDelete.executeUpdate();
		      }catch(SQLException ex) {
		       throw new SQLException("Error when trying to delete the: " + locDeVeci + ":" + ex.getMessage());
		      }finally{
		       if(PSDelete !=null){
		                 PSDelete.close();
		             }
		      }
	}
	@Override
	public List<LocDeVeci> getAll() throws SQLException {
		List<LocDeVeci> locuri = new ArrayList<LocDeVeci>();

		try {
			String selectTable = "SELECT idLoc,suprafata,idParcela,numar,poza,isMonument,idCimitir,nrContractConcesiune FROM LocuriDeVeci where deleted=false";
			PSSelect = connection.prepareStatement(selectTable);
			ResultSet result = PSSelect.executeQuery(selectTable);
			LocDeVeci loc;

			while (result.next()) {
				loc = new LocDeVeci(result.getInt(1), result.getInt(2),
						result.getInt(3), result.getInt(4), result.getBytes(5),
						result.getBoolean(6), result.getInt(7), result.getInt(8));
				locuri.add(loc);
			}

		} catch (SQLException ex) {
			throw new SQLException("Error when trying to retrieve the :"
						+ ex.getMessage());
			
		} finally {
			if (PSSelect != null) 
					PSSelect.close();
		}
		return locuri;
	}

	@Override
	public LocDeVeci getById(int idLoc) throws SQLException {
		LocDeVeci locDeVeci=null;
		try{

			String selectTable = "SELECT * FROM LocuriDeVeci WHERE idLoc = " + String.valueOf(idLoc);
			PSSelect = connection.prepareStatement(selectTable);

			ResultSet result = PSSelect.executeQuery(selectTable);


			while(result.next()) {
				locDeVeci = new LocDeVeci(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4),
						result.getBytes(5), result.getBoolean(6), result.getInt(7), result.getInt(8));

			}

		}catch(SQLException ex) {
			throw new SQLException("Error when trying to retrieve the LocDeVeci:" + ex.getMessage());
		}finally{
			if(PSSelect !=null){
				PSSelect.close();
			}
		}
		return locDeVeci;
	}
}
