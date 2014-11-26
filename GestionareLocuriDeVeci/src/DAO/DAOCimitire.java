package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Domain.Cimitir;

public class DAOCimitire implements IDAOCimitire{

	private Connection connection = null;
	PreparedStatement PSInsert = null;
    PreparedStatement PSUpdate = null;
    PreparedStatement PSDelete = null;
    PreparedStatement PSSelect = null;
    
    public DAOCimitire() {
    	
    	connection = ConnectionFactory.getConnection();
    }
    
    public void insert(Cimitir cimitir) throws SQLException{
    	
    	try{
    	 String insertTable = "INSERT INTO cimitire" + "(denumire, adresa, nrLocuri, nrParcele) VALUES" + "(? , ?, ?, ?)";
    	 PSInsert = connection.prepareStatement(insertTable);
    	 PSInsert.setString(1, cimitir.getDenumire());
    	 PSInsert.setString(2, cimitir.getAdresa());
    	 PSInsert.setInt(3, cimitir.getNrLocuri());
    	 PSInsert.setInt(4, cimitir.getNrParcele());
    	 PSInsert.executeUpdate();
    	}catch(SQLException ex){
    		throw new SQLException("Error when trying to insert the: " + cimitir + ":" + ex.getMessage());
    	}finally{
    		if(PSInsert !=null){
                PSInsert.close();
            }
    	}
    }
    
    public void delete(Cimitir cimitir) throws SQLException {
    	
    	try{
    	 String deleteTable = "DELETE FROM cimitire " + "WHERE idCimitir = ?";
    	 PSDelete = connection.prepareStatement(deleteTable);
    	 PSDelete.setInt(1, cimitir.getIdCimitir());
    	 PSDelete.executeUpdate();
    	}catch(SQLException ex) {
    		throw new SQLException("Error when trying to delete the: " + cimitir + ":" + ex.getMessage());
    	}finally{
    		if(PSDelete !=null){
                PSDelete.close();
            }
    	}
    }
    
    public void update(Cimitir cimitir) throws SQLException{
    	
    	try{
       	 String updateTable = "UPDATE cimitire SET denumire = ?, adresa = ?, nrLocuri = ?, nrParcele = ? WHERE idCimitir = ?";
       	 PSUpdate = connection.prepareStatement(updateTable);
       	 PSUpdate.setInt(5, cimitir.getIdCimitir());
       	 PSUpdate.setString(1, cimitir.getDenumire());
       	 PSUpdate.setString(2, cimitir.getAdresa());
       	 PSUpdate.setInt(3, cimitir.getNrLocuri());
       	 PSUpdate.setInt(4, cimitir.getNrParcele());
       	 PSUpdate.executeUpdate();
       	}catch(SQLException ex){
       		throw new SQLException("Error when trying to update the: " + cimitir + ":" + ex.getMessage());
       	}finally{
       		if(PSInsert !=null){
                PSInsert.close();
            }
       	}
    }
}
