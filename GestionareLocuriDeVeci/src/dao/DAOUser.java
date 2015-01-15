package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;

public class DAOUser implements IDAOUser{
	
	private Connection connection = null;
	PreparedStatement PSInsert = null;
    PreparedStatement PSUpdate = null;
    PreparedStatement PSDelete = null;
    PreparedStatement PSSelect = null;
    
    public DAOUser() {
    	
    	connection = ConnectionFactory.getConnection();
    }
    
    public void insert(User user) throws SQLException{
    	
    	try{
    	 String insertTable = "INSERT INTO useri" + "(idUseri, username, password) VALUES" + "(? , ?, ?)";
    	 PSInsert = connection.prepareStatement(insertTable);
    	 PSInsert.setInt(1, user.getIdUser());
    	 PSInsert.setString(2, user.getUsername());
    	 PSInsert.setString(3, user.getPassword());
    	 PSInsert.executeUpdate();
    	}catch(SQLException ex){
    		throw new SQLException("Error when trying to insert the: " + user + ":" + ex.getMessage());
    	}finally{
    		if(PSInsert !=null){
                PSInsert.close();
            }
    	}
    }
    
    public void delete(User user) throws SQLException {
    	
    	try{
    	 String deleteTable = "DELETE from useri WHERE idUseri = ?";
    	 PSDelete = connection.prepareStatement(deleteTable);
    	 PSDelete.setInt(1, user.getIdUser());
    	 PSDelete.executeUpdate();
    	}catch(SQLException ex) {
    		throw new SQLException("Error when trying to delete the: " + user + ":" + ex.getMessage());
    	}finally{
    		if(PSDelete !=null){
                PSDelete.close();
            }
    	}
    }
    
    public void update(User user) throws SQLException{
    	
    	try{
       	 String insertTable = "UPDATE useri SET username = ?, password = ? WHERE idUseri = ?";
       	 PSUpdate = connection.prepareStatement(insertTable);
       	 PSUpdate.setInt(3, user.getIdUser());
       	 PSUpdate.setString(1, user.getUsername());
       	 PSUpdate.setString(2, user.getPassword());
 
       	PSUpdate.executeUpdate();
       	}catch(SQLException ex){
       		throw new SQLException("Error when trying to update the: " + user + ":" +ex.getMessage());
       	}finally{
       		if(PSUpdate !=null){
       			PSUpdate.close();
            }
       	}
    }
	
	public List<User> getAll() throws SQLException {		    	
		    	List<User> userList = new ArrayList<User>();
		    	
		    	try{
		    	String selectTable = "SELECT idUseri, username, password from useri";
		    	PSSelect = connection.prepareStatement(selectTable);
		    	ResultSet result = PSSelect.executeQuery(selectTable);
		    	User user;
		    	
		    	while(result.next()) {
		    		user = new User(result.getInt(1), result.getString(2), result.getString(3));
		    		userList.add(user);
		    	}
		    	
		    	}catch(SQLException ex) {
		    		throw new SQLException("Error when trying to retrieve the users from database:" + ex.getMessage());
		    	}finally{
		    		if(PSSelect !=null){
		                PSSelect.close();
		            }
		    	}
		    	return userList;	    
	}

	@Override
	public User getByUsername(String username) throws SQLException {
		User user = null;
		try{
	    	String selectTable = "SELECT idUseri, username, password FROM useri where username = ?";
	    	PSSelect = connection.prepareStatement(selectTable);
	    	PSSelect.setString(1, username);
	    	ResultSet result = PSSelect.executeQuery();
	    	
	    	
	    	while(result.next()) {
	    		user = new User(result.getInt(1), result.getString(2), result.getString(3));
	    	}
	    	
	    	}catch(SQLException ex) {
	    		throw new SQLException("Error when trying to retrieve the inregistrariJurnal:" + ex.getMessage());
	    	}finally{
	    		if(PSSelect !=null){
	                PSSelect.close();
	            }
	    	}
	    	return user;
	}
}
