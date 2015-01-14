package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Cimitir;
import domain.Concesionar;
import domain.DatePersonale;

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
    	 String insertTable = "INSERT INTO Concesionari" + "(domiciliu, nrChitanta, cnpConcesionar, deleted) VALUES" + "(? , ?, ?, false)";
    	 PSInsert = connection.prepareStatement(insertTable);
    	 PSInsert.setString(1, concesionar.getDomiciliu());
    	 PSInsert.setInt(2, concesionar.getNrChitanta());
    	 PSInsert.setString(3, concesionar.getCnpConcesionar());
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
		try{
			String updateTable = "UPDATE Concesionari SET domiciliu = ?, nrChitanta = ?, cnpConcesionar = ? WHERE idConcesionar = ?";
			PSUpdate = connection.prepareStatement(updateTable);
			PSUpdate.setInt(4, concesionar.getIdConcesionar());
			PSUpdate.setString(1, concesionar.getDomiciliu());
			PSUpdate.setInt(2, concesionar.getNrChitanta());
			PSUpdate.setString(3, concesionar.getCnpConcesionar());
			PSUpdate.executeUpdate();
		}catch(SQLException ex){
			throw new SQLException("Error when trying to update the: " + concesionar + ":" + ex.getMessage());
		}finally{
			if(PSInsert !=null){
				PSInsert.close();
			}
		}
		
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
		try{
			String selectTable = "SELECT * FROM Concesionari WHERE deleted=false";
			PSSelect = connection.prepareStatement(selectTable);

			ResultSet result = PSSelect.executeQuery(selectTable);
			Concesionar c;

			while(result.next()) {
				c = new Concesionar(result.getInt(1),result.getString(2),result.getInt(3),result.getString(4));
				concesionari.add(c);
			}

		}catch(SQLException ex) {
			throw new SQLException("Error in getAll Concesionari:" + ex.getMessage());
		}finally{
			if(PSSelect !=null){
				PSSelect.close();
			}
		}
		return concesionari;
	}

	@Override
	public Concesionar getConcesionarById(int idConcesionar) throws SQLException {
		Concesionar concesionar=null;
		try{

			String selectTable = "SELECT * FROM Concesionari WHERE idConcesionar = " + String.valueOf(idConcesionar);
			PSSelect = connection.prepareStatement(selectTable);

			ResultSet result = PSSelect.executeQuery(selectTable);


			while(result.next()) {
				concesionar = new Concesionar(result.getInt(1),result.getString(2),result.getInt(3),result.getString(4));

			}

		}catch(SQLException ex) {
			throw new SQLException("Error when trying to retrieve the Concesionar:" + ex.getMessage());
		}finally{
			if(PSSelect !=null){
				PSSelect.close();
			}
		}
		return concesionar;
	}
	public Concesionar getConcesionarFromCNP(String CNP) throws SQLException {
		Concesionar concesionar =null;
		try{
			String selectTable = "select * from concesionari where cnpConcesionar=? ";
			System.out.println("bla");
			PSSelect = connection.prepareStatement(selectTable);
			PSSelect.setString(1,CNP);
			ResultSet result = PSSelect.executeQuery();
			if(result.next()) {
				concesionar = new Concesionar(Integer.valueOf(result.getString(1)),result.getString(2),Integer.valueOf(result.getString(3)),result.getString(4));
                System.out.println("concesionar"+concesionar.getCnpConcesionar());
			}

		}catch(SQLException ex) {
			throw new SQLException("Error when trying to retrieve the concesionar:" + ex.getMessage());
		}finally{
			if(PSSelect !=null){
				PSSelect.close();
			}
		}
		return concesionar;
	}

}
