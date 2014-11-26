package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Domain.Concesionar;

public class DAOConcesionari implements IDAOConcesionari {

	private Connection connection = null;
	PreparedStatement PSInsert = null;
	PreparedStatement PSSelect = null;
    
    public DAOConcesionari() {
    	
    	connection = ConnectionFactory.getConnection();
    }
    
    public void insert(Concesionar concesionar) throws SQLException{
    	
    	try{
    	 String insertTable = "INSERT INTO concesionari" + "(domiciliu, nrChitanta, cnpConcesionar, idLocDeVeci) VALUES" + "(? , ?, ?, ?)";
    	 PSInsert = connection.prepareStatement(insertTable);
    	 PSInsert.setString(1, concesionar.getDomiciliu());
    	 PSInsert.setInt(2, concesionar.getNrChitanta());
    	 PSInsert.setString(3, concesionar.getCnpConcesionar());
    	 PSInsert.setInt(4, concesionar.getIdLocDeVeci());
    	 PSInsert.executeUpdate();
    	}catch(SQLException ex){
    		throw new SQLException("Error when trying to insert the: " + concesionar + ":" + ex.getMessage());
    	}finally{
    		if(PSInsert !=null){
                PSInsert.close();
            }
    	}
    }
}
