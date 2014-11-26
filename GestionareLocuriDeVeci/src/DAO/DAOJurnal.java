package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.InregistrareJurnal;

public class DAOJurnal implements IDAOJurnal{

	private Connection connection = null;
	PreparedStatement PSInsert = null;
    PreparedStatement PSUpdate = null;
    PreparedStatement PSDelete = null;
    PreparedStatement PSSelect = null;
    
    public DAOJurnal() {
    	
    	connection = ConnectionFactory.getConnection();
    }
    
    public void insert(InregistrareJurnal inregistrareJurnal) throws SQLException{
    	
    	try{
    	 String insertTable = "INSERT INTO InregistrariJurnal" + "(dataOra,detaliiModificare) VALUES" + "(? , ?)";
    	 PSInsert = connection.prepareStatement(insertTable);
    	 PSInsert.setTimestamp(1, inregistrareJurnal.getDataOra());
    	 PSInsert.setString(2, inregistrareJurnal.getDetaliiModificare());
    	 PSInsert.executeUpdate();
    	}catch(SQLException ex){
    		throw new SQLException("Error when trying to insert the: " + inregistrareJurnal + ":" + ex.getMessage());
    	}finally{
    		if(PSInsert !=null){
                PSInsert.close();
            }
    	}
    }
    
    public void delete(InregistrareJurnal inregistrareJurnal) throws SQLException {
    	
    	try{
    	 String deleteTable = "DELETE FROM inregistrarijurnal " + "WHERE nrInregistrare = ?";
    	 PSDelete = connection.prepareStatement(deleteTable);
    	 PSDelete.setInt(1, inregistrareJurnal.getNrInregistare());
    	 PSDelete.executeUpdate();
    	}catch(SQLException ex) {
    		throw new SQLException("Error when trying to delete the: " + inregistrareJurnal + ":" + ex.getMessage());
    	}finally{
    		if(PSDelete !=null){
                PSDelete.close();
            }
    	}
    }
    
    public void update(InregistrareJurnal inregistrareJurnal) throws SQLException{
    	
    	try{
    	String updateTable = "UPDATE inregistrarijurnal SET dataOra = ?, detaliiModificare = ?" + "WHERE nrInregistrare = ?";
    	PSUpdate = connection.prepareStatement(updateTable);
    	PSUpdate.setTimestamp(1, inregistrareJurnal.getDataOra());
    	PSUpdate.setString(2, inregistrareJurnal.getDetaliiModificare());
    	PSUpdate.setInt(3, inregistrareJurnal.getNrInregistare());
    	PSUpdate.executeUpdate();
    	}catch(SQLException ex) {
    		throw new SQLException("Error when trying to update the: " + inregistrareJurnal + ":" + ex.getMessage());
    	}finally{
    		if(PSUpdate !=null){
                PSUpdate.close();
            }
    	}
    }
    
    public List<InregistrareJurnal> getAll() throws SQLException{
    	
    	List<InregistrareJurnal> inregistrareJurnalList = new ArrayList<InregistrareJurnal>();
    	
    	try{
    	String selectTable = "SELECT * FROM inregistrarijurnal";
    	PSSelect = connection.prepareStatement(selectTable);
    	ResultSet result = PSSelect.executeQuery(selectTable);
    	InregistrareJurnal inregistrareJurnal;
    	
    	while(result.next()) {
    		inregistrareJurnal = new InregistrareJurnal(result.getInt(1), result.getTimestamp(2), result.getString(3));
    		inregistrareJurnalList.add(inregistrareJurnal);
    	}
    	
    	}catch(SQLException ex) {
    		throw new SQLException("Error when trying to retrieve the inregistrariJurnal:" + ex.getMessage());
    	}finally{
    		if(PSSelect !=null){
                PSSelect.close();
            }
    	}
    	return inregistrareJurnalList;
    }
}
