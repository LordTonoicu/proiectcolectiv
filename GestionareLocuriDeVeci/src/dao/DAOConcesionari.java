package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import domain.Concesionar;

public class DAOConcesionari implements IDAOConcesionari {

	private Connection connection = null;
	PreparedStatement PSInsert = null;
	PreparedStatement PSSelect = null;
	PreparedStatement PSDelete = null;
    
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

	@Override
	public void update(Concesionar concesionar) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Concesionar concesionar) throws SQLException {
		try{
			String deleteTable = "UPDATE Concesionari SET deleted=true " + "WHERE idConcesionat = ?";
			PSDelete = connection.prepareStatement(deleteTable);
			PSDelete.setInt(1, concesionar.getIdConcesionar());
			PSDelete.executeUpdate();
		}catch(SQLException ex) {
			throw new SQLException("Error when trying to delete the: " + concesionar + ":" + ex.getMessage());
		}finally{
			if(PSDelete !=null){
				PSDelete.close();
			}
		}
		
	}

	@Override
	public List<Concesionar> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Concesionar getConcesionarById(int idConcesionar) {
		// TODO Auto-generated method stub
		return null;
	}
}
