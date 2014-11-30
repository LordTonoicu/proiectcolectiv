package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.DatePersonale;
import domain.Decedat;

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
    	 String insertTable = "INSERT INTO DatePersonale" + "(cnp, nume, prenume) VALUES" + "(? , ? , ?)";
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
    	 String deleteTable = "DELETE FROM DatePersonale " + "WHERE cnp = ?";
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
       	 String insertTable = "UPDATE DatePersonale SET nume = ?, prenume = ? WHERE cnp = ?";
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
 public DatePersonale getDatePersonaleFromDecedat(Decedat decedat) throws SQLException{
	 DatePersonale dataPersonala =null;
    	try{
       	 String selectTable = "select * from DatePersonale where DatePersonale.cnp = "+decedat.getCnpDecedat();
       	PSSelect = connection.prepareStatement(selectTable);
    	ResultSet result = PSSelect.executeQuery(selectTable);
    	
    	
    	if(result.next()) {
    		dataPersonala = new DatePersonale(result.getString(1),result.getString(2),result.getString(3));
    	
    	}
    	
    	}catch(SQLException ex) {
    		throw new SQLException("Error when trying to retrieve the inregistrariJurnal:" + ex.getMessage());
    	}finally{
    		if(PSSelect !=null){
                PSSelect.close();
            }
    	}
    	return dataPersonala;
    }

@Override
public DatePersonale getDatePersonaleFromCNP(String CNP) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}
