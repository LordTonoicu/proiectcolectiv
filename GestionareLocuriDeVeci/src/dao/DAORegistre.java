package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import domain.registers.InregRegAnualDeProgrInmormantari;
import domain.registers.InregRegAnualDecedati;
import domain.registers.InregRegCereriInhumare;
import domain.registers.InregRegContracteConcesiune;
import domain.registers.InregRegDeMorminte;
import domain.registers.InregRegDecedatiFaraApartinatori;
import domain.registers.InregRegMorminteMonFunerareVal;

public class DAORegistre implements IDAORegistre{

	@Override
	public List<InregRegAnualDeProgrInmormantari> getRegAnualDeProgramareAInmormantarilor()
			throws SQLException {
		List<InregRegAnualDeProgrInmormantari>  registru = null;
		try
		{
			int year = Calendar.getInstance().get(Calendar.YEAR);
			String sqlSelect ="SELECT dp.nume, dp.prenume, d.religie, c.denumire, "
					+"p.denumire, l.numar, d.dataInmormantare FROM Decedati d "
					+"INNER JOIN DatePersonale dp ON d.cnpDecedat=dp.cnp "
					+"INNER JOIN LocuriDeVeci l ON d.idLocDeVeci = l.idLoc "
					+"INNER JOIN Parcele p ON l.idParcela = p.idParcela "
					+"INNER JOIN Cimitire c ON p.idCimitir = c.idCimitir "
					+"where YEAR(d.dataInmormantare)>"+String.valueOf(year-1)+ " AND YEAR(d.dataInmormantare)<"+String.valueOf(year+1);
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegAnualDeProgrInmormantari>();
			InregRegAnualDeProgrInmormantari inreg;
			while(rs.next())
			{
				inreg = new InregRegAnualDeProgrInmormantari(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4),rs.getString(5), String.valueOf(rs.getInt(6)), 
						 rs.getDate(7));
				registru.add(inreg);
			}
		}
		catch (SQLException ex)
		{
			throw new SQLException("Exceptie Accesare Date Registru: " + ex.getMessage());
		}
		return registru;
	}

	
	@Override
	public List<InregRegDeMorminte> getRegDeMorminte() throws SQLException {
		List<InregRegDeMorminte> registru = null;
		try{
			String sqlSelect = ""/*TODO*/;
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegDeMorminte>();
			while(rs.next())
			{
				InregRegDeMorminte inregistrare = new InregRegDeMorminte(/*TODO*/);
				registru.add(inregistrare);
			}
		} catch (SQLException ex){
			throw new SQLException("Exceptie Accesare Date Registru: " + ex.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegMorminteMonFunerareVal> getRegDeMorminteMonFunerare() throws SQLException {
		List<InregRegMorminteMonFunerareVal> registru = null;
		try{
			String sqlSelect = ""/*TODO*/;
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegMorminteMonFunerareVal>();
			while(rs.next())
			{
				InregRegMorminteMonFunerareVal inregistrare = new InregRegMorminteMonFunerareVal(/*TODO*/);
				registru.add(inregistrare);
			}
		} catch (SQLException ex){
			throw new SQLException("Exceptie Accesare Date Registru: " + ex.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegAnualDecedati> getRegAnualDecedati() throws SQLException {
		List<InregRegAnualDecedati> registru = null;
		try{
			String sqlSelect = ""/*TODO*/;
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegAnualDecedati>();
			while(rs.next())
			{
				InregRegAnualDecedati inregistrare = new InregRegAnualDecedati(/*TODO*/);
				registru.add(inregistrare);
			}
		} catch (SQLException ex){
			throw new SQLException("Exceptie Accesare Date Registru: " + ex.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegDecedatiFaraApartinatori> getRegAnualDecedatiFaraApartinatori()
			throws SQLException {
		List<InregRegDecedatiFaraApartinatori> registru = null;
		try{
			String sqlSelect = ""/*TODO*/;
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegDecedatiFaraApartinatori>();
			while(rs.next())
			{
				InregRegDecedatiFaraApartinatori inregistrare = new InregRegDecedatiFaraApartinatori(/*TODO*/);
				registru.add(inregistrare);
			}
		} catch (SQLException ex){
			throw new SQLException("Exceptie Accesare Date Registru: " + ex.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegCereriInhumare> getRegCereriInhumare()
			throws SQLException {
		List<InregRegCereriInhumare> registru = null;
		try{
			String sqlSelect = ""/*TODO*/;
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegCereriInhumare>();
			while(rs.next())
			{
				InregRegCereriInhumare inregistrare = new InregRegCereriInhumare(/*TODO*/);
				registru.add(inregistrare);
			}
		} catch (SQLException ex){
			throw new SQLException("Exceptie Accesare Date Registru: " + ex.getMessage());
		}
		return registru;
	}

	@Override
	public List<InregRegContracteConcesiune> getRegContracteConcesiune()
			throws SQLException {
		List<InregRegContracteConcesiune> registru=null;
		try
		{
			int year = Calendar.getInstance().get(Calendar.YEAR);
			//TODO: needs testing...
			String sqlSelect ="select nrContract, dataEliberare, dp.nume, dp.prenume, c.domiciliu from ContracteConcesiune cc"
					+"INNER JOIN Concesionari c ON cnpConcesionar1=c.cnpConcesionar "
					+"INNER JOIN DatePersonale dp ON c.cnpConcesionar=dp.cnp "
					+"where c.deleted=false AND YEAR(dataEliberare)>"+String.valueOf(year-1)
					+" AND YEAR(dataEliberare)<"+String.valueOf(year+1)
					+" UNION "
					+"select nrContract, dataEliberare, dp.nume, dp.prenume, c.domiciliu from ContracteConcesiune cc"
					+"INNER JOIN Concesionari c ON cnpConcesionar2=c.cnpConcesionar "
					+"INNER JOIN DatePersonale dp ON c.cnpConcesionar=dp.cnp "
					+"where c.deleted=false AND YEAR(dataEliberare)>"+String.valueOf(year-1)
					+" AND YEAR(dataEliberare)<"+String.valueOf(year+1);
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegContracteConcesiune>();
			InregRegContracteConcesiune inreg;
			int i=1;
			while(rs.next())
			{
			inreg = new InregRegContracteConcesiune(i,rs.getInt(1),rs.getDate(2),
					rs.getString(3),rs.getString(4),rs.getString(5));
			registru.add(inreg);
			i++;
			}
		}
		catch (SQLException ex)
		{
			throw new SQLException("Exceptie Accesare Date Registru: " + ex.getMessage());
		}
		return registru;
	}

}
