package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Parcela;

public class DAOParcele implements IDAOParcele {

	private Connection connection = null;
	PreparedStatement PSInsert = null;
    PreparedStatement PSUpdate = null;
    PreparedStatement PSDelete = null;
    PreparedStatement PSSelect = null;
    
    public DAOParcele() {
    	
    	connection = ConnectionFactory.getConnection();
    }
    
    public void insert(Parcela parcela) throws SQLException{
    	
    	try{
    	 String insertTable = "INSERT INTO Parcele" + "(denumire, nrLocuri, idCimitir, hasMonument, deleted) VALUES" + "(? , ?, ?, ?,false)";
    	 PSInsert = connection.prepareStatement(insertTable);
    	 PSInsert.setString(1, parcela.getDenumire());
    	 PSInsert.setInt(2, parcela.getNrLocuri());
    	 PSInsert.setInt(3, parcela.getIdCimitir());
    	 if(parcela.getHasMonument() == true) {
    		 PSInsert.setInt(4, 1);
    	 }else {
    		 PSInsert.setInt(4, 0); 
    	 }
    	 PSInsert.executeUpdate();
    	}catch(SQLException ex){
    		throw new SQLException("Error when trying to insert the: " + parcela + ":" + ex.getMessage());
    	}finally{
    		if(PSInsert !=null){
                PSInsert.close();
            }
    	}
    }
    
    public void delete(Parcela parcela) throws SQLException {
    	
    	try{
    	 String deleteTable = "UPDATE Parcele set deleted=true " + "WHERE idParcela = ?";
    	 PSDelete = connection.prepareStatement(deleteTable);
    	 PSDelete.setInt(1, parcela.getIdParcela());
    	 PSDelete.executeUpdate();
    	}catch(SQLException ex) {
    		throw new SQLException("Error when trying to delete the: " + parcela + ":" + ex.getMessage());
    	}finally{
    		if(PSDelete !=null){
                PSDelete.close();
            }
    	}
    }
    
    public void update(Parcela parcela) throws SQLException{
    	
    	try{
       	 String insertTable = "UPDATE Parcele SET denumire = ?, nrLocuri = ?, idCimitir = ?, hasMonument =? WHERE idParcela = ?";
       	 PSUpdate = connection.prepareStatement(insertTable);
       	 PSUpdate.setInt(5, parcela.getIdParcela());
       	 PSUpdate.setString(1, parcela.getDenumire());
       	 PSUpdate.setInt(2, parcela.getNrLocuri());
       	 PSUpdate.setInt(3, parcela.getIdCimitir());
       	 if(parcela.getHasMonument() == true) {
       		PSUpdate.setInt(4, 1);
       	 }else {
       		PSUpdate.setInt(4, 0); 
       	 }
       	PSUpdate.executeUpdate();
       	}catch(SQLException ex){
       		throw new SQLException("Error when trying to update the: " + parcela + ":" +ex.getMessage());
       	}finally{
       		if(PSUpdate !=null){
       			PSUpdate.close();
            }
       	}
    }
	
	public List<Parcela> getAllParcele() throws SQLException {		    	
		    	List<Parcela> parcele = new ArrayList<Parcela>();
		    	
		    	try{
		    	String selectTable = "SELECT idParcela, denumire, nrLocuri, idCimitir, hasMonument FROM Parcele where deleted=false";
		    	PSSelect = connection.prepareStatement(selectTable);
		    	ResultSet result = PSSelect.executeQuery(selectTable);
		    	Parcela parcela;
		    	
		    	while(result.next()) {
		    		parcela = new Parcela(result.getInt(1),result.getString(2),result.getInt(3),result.getInt(4),result.getBoolean(5));
		    		parcele.add(parcela);
		    	}
		    	
		    	}catch(SQLException ex) {
		    		throw new SQLException("Error when trying to retrieve the inregistrariJurnal:" + ex.getMessage());
		    	}finally{
		    		if(PSSelect !=null){
		                PSSelect.close();
		            }
		    	}
		    	return parcele;
		    
	}

	@Override
	public Parcela getById(int id) throws SQLException {
		return null;
	}
}
