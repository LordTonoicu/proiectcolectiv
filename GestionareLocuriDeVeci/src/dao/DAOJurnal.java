package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.InregistrareJurnal;

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
    	 String insertTable = "INSERT INTO InregistrariJurnal" + "(dataOra,detaliiModificare, user) VALUES" + "(? , ? , ?)";
    	 PSInsert = connection.prepareStatement(insertTable);
    	 PSInsert.setTimestamp(1, inregistrareJurnal.getDataOra());
    	 PSInsert.setString(2, inregistrareJurnal.getDetaliiModificare());
    	 PSInsert.setString(3, inregistrareJurnal.getUser());
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
    	 String deleteTable = "DELETE FROM InregistrariJurnal " + "WHERE nrInregistrare = ?";
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
    	String updateTable = "UPDATE InregistrariJurnal SET dataOra = ?, detaliiModificare = ? user = ?" + "WHERE nrInregistrare = ?";
    	PSUpdate = connection.prepareStatement(updateTable);
    	PSUpdate.setTimestamp(1, inregistrareJurnal.getDataOra());
    	PSUpdate.setString(2, inregistrareJurnal.getDetaliiModificare());
    	PSUpdate.setString(3, inregistrareJurnal.getUser());
    	PSUpdate.setInt(4, inregistrareJurnal.getNrInregistare());
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
    	String selectTable = "SELECT * FROM InregistrariJurnal ORDER BY nrInregistrare DESC";
    	
    	PSSelect = connection.prepareStatement(selectTable);
    	ResultSet result = PSSelect.executeQuery(selectTable);
    	InregistrareJurnal inregistrareJurnal;
    	
    	while(result.next()) {
    		inregistrareJurnal = new InregistrareJurnal(result.getInt(1), result.getTimestamp(2), result.getString(3), result.getString(4));
    		inregistrareJurnalList.add(inregistrareJurnal);
    	}
    	
    	}catch(SQLException ex) {
    		throw new SQLException("Error when trying to retrieve the InregistrariJurnal:" + ex.getMessage());
    	}finally{
    		if(PSSelect !=null){
                PSSelect.close();
            }
    	}
    	return inregistrareJurnalList;
    }
}
