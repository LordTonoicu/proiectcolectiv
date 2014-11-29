package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.LocDeVeci;

public class DAOLocuri implements IDAOLocuri {

	private Connection connection = null;
	PreparedStatement PSInsert = null;
    PreparedStatement PSUpdate = null;
    PreparedStatement PSSelect = null;
    
    public DAOLocuri() {
    	
    	connection = ConnectionFactory.getConnection();
    }
    
    public void insert(LocDeVeci locDeVeci) throws SQLException{
    	
    	try{
    	 String insertTable = "INSERT INTO locurideveci" + "(suprafata,idParcela,numar,poza,isMonument,idCimitir) VALUES" + "(? , ?, ?, ?, ?, ?)";
    	 PSInsert = connection.prepareStatement(insertTable);
    	 PSInsert.setInt(1, locDeVeci.getSuprafata());
    	 PSInsert.setInt(2, locDeVeci.getIdParcela());
    	 PSInsert.setInt(3, locDeVeci.getNumar());
    	 PSInsert.setBlob(4, locDeVeci.getPoza());
    	 if(locDeVeci.isMonument() == true) {
    	 PSInsert.setInt(5, 1);
    	}else{
    		PSInsert.setInt(5, 0);
    	}
    	 PSInsert.setInt(7, locDeVeci.getIdCimitir());
    	 PSInsert.executeUpdate();
    	}catch(SQLException ex){
    		throw new SQLException("Error when trying to insert the: " + locDeVeci + ":" + ex.getMessage());
    	}finally{
    		if(PSInsert !=null){
                PSInsert.close();
            }
    	}
    }
    
    public void update(LocDeVeci locDeVeci) throws SQLException{
    	
    	try{
       	 String updateTable = "UPDATE locurideveci SET suprafata = ?, idParcela = ?,numar = ?, poza = ?, isMonument = ?, idCimitir = ?) WHERE idLoc = ?";
       	 PSUpdate = connection.prepareStatement(updateTable);
       	 PSUpdate.setInt(7, locDeVeci.getIdLoc());
       	 PSUpdate.setInt(1, locDeVeci.getSuprafata());
       	 PSUpdate.setInt(2, locDeVeci.getIdParcela());
       	 PSUpdate.setInt(3, locDeVeci.getNumar());
       	 PSUpdate.setBlob(4, locDeVeci.getPoza());
       	 if(locDeVeci.isMonument() == true) {
       	 PSUpdate.setInt(5, 1);
       	}else {
       		PSUpdate.setInt(5, 0);
       	}
       	 PSUpdate.setInt(6, locDeVeci.getIdCimitir());
       	 PSUpdate.executeUpdate();
       	}catch(SQLException ex){
       		throw new SQLException("Error when trying to update the: " + locDeVeci + ":" +ex.getMessage());
       	}finally{
       		if(PSUpdate !=null){
                   PSUpdate.close();
               }
       	}
    }
}
