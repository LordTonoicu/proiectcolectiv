package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Cimitir;
import domain.ContractConcesiune;

public class DAOContracteConcesiune implements IDAOContracteConcesiune {
	
	private Connection connection = null;
	PreparedStatement PSInsert = null;
	PreparedStatement PSUpdate = null;
	PreparedStatement PSDelete = null;
	PreparedStatement PSSelect = null;
	
	public DAOContracteConcesiune() {
		
		connection = ConnectionFactory.getConnection();
	} 

	@Override
	public void insert(ContractConcesiune cc) throws SQLException{
		try{
			String insertTable = "INSERT INTO ContracteConcesiune" + "(dataEliberare, cnpConcesionar1, cnpConcesionar2) VALUES" + "(? , ?, ? false)";
			PSInsert = connection.prepareStatement(insertTable);
			PSInsert.setDate(1, cc.getDataEliberare());
			PSInsert.setString(2, cc.getCnpConcesionar1());
			PSInsert.setString(3, cc.getCnpConcesionar2());
			PSInsert.executeUpdate();
		}catch(SQLException ex){
			throw new SQLException("Error when trying to insert the: " + cc + ":" + ex.getMessage());
		}finally{
			if(PSInsert !=null){
				PSInsert.close();
			}
		}
		
	}

	@Override
	public void delete(ContractConcesiune cc) throws SQLException{
		try{
			String deleteTable = "UPDATE ContracteConcesiune SET deleted=true " + "WHERE nrContract = ?";
			PSDelete = connection.prepareStatement(deleteTable);
			PSDelete.setInt(1, cc.getNrContract());
			PSDelete.executeUpdate();
		}catch(SQLException ex) {
			throw new SQLException("Error when trying to delete the: " + cc + ":" + ex.getMessage());
		}finally{
			if(PSDelete !=null){
				PSDelete.close();
			}
		}
		
	}

	@Override
	public void update(ContractConcesiune cc) throws SQLException{
		try{
			String updateTable = "UPDATE ContracteConcesiune SET dataEliberare = ?, cnpConcesionar1 = ?, cnpConcesionar2 = ? WHERE nrContract = ?";
			PSUpdate = connection.prepareStatement(updateTable);
			PSUpdate.setInt(4, cc.getNrContract());
			PSUpdate.setDate(1, cc.getDataEliberare());
			PSUpdate.setString(2, cc.getCnpConcesionar1());
			PSUpdate.setString(3, cc.getCnpConcesionar2());
			PSUpdate.executeUpdate();
		}catch(SQLException ex){
			throw new SQLException("Error when trying to update the: " + cc + ":" + ex.getMessage());
		}finally{
			if(PSInsert !=null){
				PSInsert.close();
			}
		}
		
	}

	@Override
	public List<ContractConcesiune> getAll() throws SQLException{
		List<ContractConcesiune> contracteConcesiune = new ArrayList<ContractConcesiune>();

		try{
			String selectTable = "SELECT * FROM ContracteConcesiune WHERE deleted=false";
			PSSelect = connection.prepareStatement(selectTable);

			ResultSet result = PSSelect.executeQuery(selectTable);
			ContractConcesiune cc; 

			while(result.next()) {
				cc = new ContractConcesiune(result.getInt(1),result.getDate(2),result.getString(3),result.getString(4));
				contracteConcesiune.add(cc);
			}

		}catch(SQLException ex) {
			throw new SQLException("Error when trying to retrieve the ContractConcesiune by id:" + ex.getMessage());
		}finally{
			if(PSSelect !=null){
				PSSelect.close();
			}
		}
		return contracteConcesiune;
	}
	
	 @Override
	 public ContractConcesiune getByNumarContract(int id) throws SQLException {
		 ContractConcesiune cc=null;
			try{

				String selectTable = "SELECT * FROM ContracteConcesiune WHERE nrContract = " + String.valueOf(id);
				PSSelect = connection.prepareStatement(selectTable);

				ResultSet result = PSSelect.executeQuery(selectTable);


				while(result.next()) {
					cc = new ContractConcesiune(result.getInt(1),result.getDate(2),result.getString(3),result.getString(4));

				}

			}catch(SQLException ex) {
				throw new SQLException("Error when trying to retrieve the ContractConcesiune:" + ex.getMessage());
			}finally{
				if(PSSelect !=null){
					PSSelect.close();
				}
			}
			return cc;
	 }
	

}
