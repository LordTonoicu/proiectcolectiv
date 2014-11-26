package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Domain.Parcela;

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
    	 String insertTable = "INSERT INTO parcele" + "(denumire, nrLocuri, idCimitir, hasMonument) VALUES" + "(? , ?, ?, ?)";
    	 PSInsert = connection.prepareStatement(insertTable);
    	 PSInsert.setString(1, parcela.getDenumire());
    	 PSInsert.setInt(2, parcela.getNrLocuri());
    	 PSInsert.setInt(3, parcela.getIdCimitir());
    	 if(parcela.isHasMonument() == true) {
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
    	 String deleteTable = "DELETE FROM parcele " + "WHERE idCimitir = ?";
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
       	 String insertTable = "UPDATE parcele SET denumire = ?, nrLocuri = ?, idCimitir = ?, hasMonument =? WHERE idParcela = ?";
       	 PSUpdate = connection.prepareStatement(insertTable);
       	 PSUpdate.setInt(5, parcela.getIdParcela());
       	 PSUpdate.setString(1, parcela.getDenumire());
       	 PSUpdate.setInt(2, parcela.getNrLocuri());
       	 PSUpdate.setInt(3, parcela.getIdCimitir());
       	 if(parcela.isHasMonument() == true) {
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
}
