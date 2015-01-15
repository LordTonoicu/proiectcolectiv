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
					+"where d.deleted=false AND YEAR(d.dataInmormantare)>"+String.valueOf(year-1)+ " AND YEAR(d.dataInmormantare)<"+String.valueOf(year+1);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InregRegMorminteMonFunerareVal> getRegDeMorminteMonFunerare()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InregRegAnualDecedati> getRegAnualDecedati()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InregRegDecedatiFaraApartinatori> getRegAnualDecedatiFaraApartinatori()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InregRegCereriInhumare> getRegCereriInhumare()
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InregRegContracteConcesiune> getRegContracteConcesiune()
			throws SQLException {
		List<InregRegContracteConcesiune> registru=null;
		try
		{
			int year = Calendar.getInstance().get(Calendar.YEAR);
			//TODO: needs testing...
			String sqlSelect ="select cc.nrContract, cc.dataEliberare, dp.nume, dp.prenume, c.domiciliu from ContracteConcesiune cc"
					+"INNER JOIN Concesionari c ON cc.cnpConcesionar1=c.cnpConcesionar "
					+"INNER JOIN DatePersonale dp ON c.cnpConcesionar=dp.cnp "
					+"where d.deleted=false AND YEAR(cc.dataEliberare)>"+String.valueOf(year-1)
					+" AND YEAR(cc.dataEliberare)<"+String.valueOf(year+1)
					+" UNION "
					+"select cc.nrContract, cc.dataEliberare, dp.nume, dp.prenume, c.domiciliu from ContracteConcesiune cc"
					+"INNER JOIN Concesionari c ON cc.cnpConcesionar2=c.cnpConcesionar "
					+"INNER JOIN DatePersonale dp ON c.cnpConcesionar=dp.cnp "
					+"where d.deleted=false AND YEAR(cc.dataEliberare)>"+String.valueOf(year-1)
					+" AND YEAR(cc.dataEliberare)<"+String.valueOf(year+1);
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
