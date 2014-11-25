package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Domain.Concesionar;

public class DAOConcesionari implements IDAOConcesionari {

	private Connection connection = null;
	PreparedStatement PSInsert = null;
    
    public DAOConcesionari() {
    	
    	connection = ConnectionFactory.getConnection();
    }
    
    public void insert(Concesionar concesionar) throws SQLException{
    	
    	try{
    	 String insertTable = "INSERT INTO concesionari" + "(idConcesionar, domiciliu, nrChitanta, cnpConcesionar, idLocDeVeci) VALUES" + "(? , ? , ?, ?, ?)";
    	 PSInsert = connection.prepareStatement(insertTable);
    	 PSInsert.setInt(1, concesionar.getIdConcesionar());
    	 PSInsert.setString(2, concesionar.getDomiciliu());
    	 PSInsert.setInt(3, concesionar.getNrChitanta());
    	 PSInsert.setString(4, concesionar.getCnpConcesionar());
    	 PSInsert.setInt(5, concesionar.getIdLocDeVeci());
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
