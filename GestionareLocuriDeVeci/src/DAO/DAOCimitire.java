package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Cimitir;
import Domain.InregistrareJurnal;

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

	@Override
	public List<Cimitir> getAllCimitire() throws SQLException {		    	
		    	List<Cimitir> cimitire = new ArrayList<Cimitir>();
		    	
		    	try{
		    	String selectTable = "SELECT * FROM cimitire";
		    	PSSelect = connection.prepareStatement(selectTable);
		    	ResultSet result = PSSelect.executeQuery(selectTable);
		    	Cimitir cimitir;
		    	
		    	while(result.next()) {
		    		cimitir = new Cimitir(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getInt(5));
		    		cimitire.add(cimitir);
		    	}
		    	
		    	}catch(SQLException ex) {
		    		throw new SQLException("Error when trying to retrieve the inregistrariJurnal:" + ex.getMessage());
		    	}finally{
		    		if(PSSelect !=null){
		                PSSelect.close();
		            }
		    	}
		    	return cimitire;
		    
	}
}
