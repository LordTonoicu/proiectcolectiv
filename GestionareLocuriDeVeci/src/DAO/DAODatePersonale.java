package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Domain.DatePersonale;

public class DAODatePersonale implements IDAODatePersonale{

	private Connection connection = null;
	PreparedStatement PSInsert = null;
    PreparedStatement PSUpdate = null;
    PreparedStatement PSDelete = null;
    PreparedStatement PSSelect = null;
    
    public DAODatePersonale() {
    	
    	connection = ConnectionFactory.getConnection();
    }
    
    public void insert(DatePersonale datePersonale) throws SQLException{
    	
    	try{
    	 String insertTable = "INSERT INTO datepersonale" + "(cnp, nume, prenume) VALUES" + "(? , ? , ?)";
    	 PSInsert = connection.prepareStatement(insertTable);
    	 PSInsert.setString(1, datePersonale.getCnp());
    	 PSInsert.setString(2, datePersonale.getNume());
    	 PSInsert.setString(3, datePersonale.getPrenume());
    	 PSInsert.executeUpdate();
    	}catch(SQLException ex){
    		throw new SQLException("Error when trying to insert the: " + datePersonale + ":" + ex.getMessage());
    	}finally{
    		if(PSInsert !=null){
                PSInsert.close();
            }
    	}
    }
    
    public void delete(DatePersonale datePersonale) throws SQLException {
    	
    	try{
    	 String deleteTable = "DELETE FROM datepersonale " + "WHERE cnp = ?";
    	 PSDelete = connection.prepareStatement(deleteTable);
    	 PSDelete.setString(1, datePersonale.getCnp());
    	 PSDelete.executeUpdate();
    	}catch(SQLException ex) {
    		throw new SQLException("Error when trying to delete the: " + datePersonale + ":" + ex.getMessage());
    	}finally{
    		if(PSDelete !=null){
                PSDelete.close();
            }
    	}
    }
    
    public void update(DatePersonale datePersonale) throws SQLException{
    	
    	try{
       	 String insertTable = "UPDATE datepersonale SET nume = ?, prenume = ? WHERE cnp = ?";
       	 PSUpdate = connection.prepareStatement(insertTable);
       	 PSUpdate.setString(1, datePersonale.getNume());
       	 PSUpdate.setString(2, datePersonale.getPrenume());
       	 PSUpdate.setString(3, datePersonale.getCnp());
       	PSUpdate.executeUpdate();
       	}catch(SQLException ex){
       		throw new SQLException("Error when trying to update the: " + datePersonale + ":" +ex.getMessage());
       	}finally{
       		if(PSUpdate !=null){
       			PSUpdate.close();
            }
       	}
    }
}
