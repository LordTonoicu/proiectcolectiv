package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import domain.Concesionar;

public class DAOConcesionari implements IDAOConcesionari {

	private Connection connection = null;
	PreparedStatement PSInsert = null;
	PreparedStatement PSSelect = null;
	PreparedStatement PSDelete = null;
	PreparedStatement PSUpdate = null;

	public DAOConcesionari() {

		connection = ConnectionFactory.getConnection();
	}

	public void insert(Concesionar concesionar) throws SQLException{

		try{
			String insertTable = "INSERT INTO concesionari" + "(domiciliu, nrChitanta, cnpConcesionar, idLocDeVeci, deleted) VALUES" + "(? , ?, ?, ?, false)";
			PSInsert = connection.prepareStatement(insertTable);
			PSInsert.setString(1, concesionar.getDomiciliu());
			PSInsert.setInt(2, concesionar.getNrChitanta());
			PSInsert.setString(3, concesionar.getCnpConcesionar());
			PSInsert.setInt(4, concesionar.getIdLocDeVeci());
			PSInsert.executeUpdate();
		}catch(SQLException ex){
			throw new SQLException("Error when trying to insert the: " + concesionar + ":" + ex.getMessage());
		}finally{
			if(PSInsert !=null){
				PSInsert.close();
			}
		}
	}

	@Override
	public void update(Concesionar concesionar) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Concesionar concesionar) throws SQLException {
		try{
			String deleteTable = "UPDATE Concesionari SET deleted=true " + "WHERE idConcesionat = ?";
			PSDelete = connection.prepareStatement(deleteTable);
			PSDelete.setInt(1, concesionar.getIdConcesionar());
			PSDelete.executeUpdate();
		}catch(SQLException ex) {
			throw new SQLException("Error when trying to delete the: " + concesionar + ":" + ex.getMessage());
		}finally{
			if(PSDelete !=null){
				PSDelete.close();
			}
		}
		
	}

	@Override
	public List<Concesionar> getAll() throws SQLException {
		ArrayList<Concesionar> concesionari = new ArrayList<Concesionar>();
		try
		{
			String selectStatement = "select * from Concesionari where deleted=false";
			PSSelect = connection.prepareStatement(selectStatement);
			ResultSet rs = PSSelect.executeQuery();
			Concesionar c;
			
			while(rs.next())
			{
				c = new Concesionar(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				concesionari.add(c);
			}
		}
		catch(SQLException ex)
		{
			throw new SQLException("Error in getAll Concesionari: " + ex.getMessage());
		}
		finally{
			if(PSSelect!=null)
				PSSelect.close();
		}
		return concesionari;
	}
	@Override
	public Concesionar getConcesionarById(int idConcesionar) {
		// TODO Auto-generated method stub
		return null;
	}
}
