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
			// selectez toate dupa decedati reunit cu decedati fara apartinatori
			String sqlSelect ="SELECT dp.nume, dp.prenume, d.religie, c.denumire, "
					+"p.denumire, l.numar, d.dataInmormantare FROM Decedati d "
					+"INNER JOIN DatePersonale dp ON d.cnpDecedat=dp.cnp "
					+"INNER JOIN LocuriDeVeci l ON d.idLocDeVeci = l.idLoc "
					+"INNER JOIN Parcele p ON l.idParcela = p.idParcela "
					+"INNER JOIN Cimitire c ON p.idCimitir = c.idCimitir "
					+"where YEAR(d.dataInmormantare)>"+String.valueOf(year-1)+ " AND YEAR(d.dataInmormantare)<"+String.valueOf(year+1)
					+" UNION "
					+ "SELECT dp.nume, dp.prenume, d.religie, c.denumire, "
					+"p.denumire, l.numar, d.dataInmormantare FROM DecedatiFaraApartinatori d "
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

	/*REGISTRUL DE MORMINTE în care se înscriu toate locurile de morminte din cimitir. În acest
	registru se va arăta – cimitirul – parcela – numărul mormântului, numele, prenumele şi domiciliul
	deţinătorului, nr. chitanţei cu care s-a făcut plata locului de mormânt, numele, prenumele celor
	înmormântaţi, data înmormântării, suprafaţa locului şi o coloană pentru observaţii, în care se va
	arăta existenţa/inexistenţa construcţiilor funerare şi numărul actului în baza căruia s-au făcut
	modificări privind schimbarea deţinătorului, fotografia scanată a locului de veci.
	 */
	@Override
	public List<InregRegDeMorminte> getRegDeMorminte() throws SQLException {
		List<InregRegDeMorminte> registru = null;
		try{
			//toate locurile de veci
			String sqlSelect = "SELECT idLoc, c.denumire, p.denumire, numar, cc.cnpConcesionar1, cc.cnpConcesionar2, suprafata from LocuriDeVeci "
					+"INNER JOIN Parcele p ON LocuriDeVeci.idParcela= p.idParcela "
					+"INNER JOIN Cimitire c ON p.idCimitir= c.idCimitir "
					+"LEFT JOIN ContracteConcesiune cc on nrContractConcesiune = cc.nrContract where LocuriDeVeci.deleted=false";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegDeMorminte>();
			while(rs.next())
			{
				InregRegDeMorminte inregistrare = new InregRegDeMorminte();
				inregistrare.setNumarMormant(rs.getInt(4));
				inregistrare.setCimitir(rs.getString(2));
				inregistrare.setParcela(rs.getString(3));
				inregistrare.setSuprafata(rs.getInt(7));
				//concesionari pentru mormant
				String sqlSelectDetinatori = "SELECT dp.nume, dp.prenume, c.domiciliu, c.nrChitanta from Concesionari c "
						+"INNER JOIN DatePersonale dp on c.cnpConcesionar = dp.cnp where dp.cnp in ('"
						+rs.getString(5)+"','"+rs.getString(6)+"')";
				PreparedStatement psConcesionar = con.prepareStatement(sqlSelectDetinatori);
				ResultSet rsDateConcesionari = psConcesionar.executeQuery();
				String numePrenume="";
				String domicilii="";
				String nrChitante="";
				if(rsDateConcesionari.next())
				{
					numePrenume+=rsDateConcesionari.getString(1) +" " + rsDateConcesionari.getString(2) + "<br>";
					domicilii+=rsDateConcesionari.getString(3)+"<br>";
					nrChitante+=rsDateConcesionari.getInt(4)+"<br>";
					if(rsDateConcesionari.next())
					{
						numePrenume+=rsDateConcesionari.getString(1) +" " + rsDateConcesionari.getString(2);
						domicilii+=rsDateConcesionari.getString(3);
						nrChitante+=rsDateConcesionari.getInt(4)+"<br>";
					}
				
				}
				else
				{
					numePrenume="-";
					domicilii="-";
					nrChitante="-";
				}
				inregistrare.setNumePrenumeDetinatori(numePrenume);
				inregistrare.setDomiciliuDetinatori(domicilii);
				inregistrare.setNumereChitante(nrChitante);
				//decedati pentru mormant
				String sqlAllDecedati = "SELECT dp.nume, dp.prenume, d.dataInmormantare from Decedati d "
						+"INNER JOIN DatePersonale dp ON d.cnpDecedat=dp.cnp WHERE d.idLocDeVeci="+rs.getInt(1)
						+" UNION "
						+"SELECT dp.nume, dp.prenume, d.dataInmormantare from DecedatiFaraApartinatori d "
						+"INNER JOIN DatePersonale dp ON d.cnpDecedat=dp.cnp WHERE d.idLocDeVeci="+rs.getInt(1);
				PreparedStatement psDecedati = con.prepareStatement(sqlAllDecedati);
				ResultSet rsDecedati = psDecedati.executeQuery();
				String numePrenumeDecedati="",dateInmormantari="";
				int i=1;
				while(rsDecedati.next())
				{
					numePrenumeDecedati+=rsDecedati.getString(1)+" " +rsDecedati.getString(2)+"<br>";
					dateInmormantari+=rsDecedati.getDate(3).toString()+"<br>";
					i++;
				}
				if(numePrenumeDecedati=="" || dateInmormantari=="")
				{
					numePrenumeDecedati="-";
					dateInmormantari="-";
				}
				inregistrare.setNumePrenumeInmormantati(numePrenumeDecedati);
				inregistrare.setDateInmormantare(dateInmormantari);
				registru.add(inregistrare);
			}
		} catch (SQLException ex){
			throw new SQLException("Exceptie Accesare Date Registru: " + ex.getMessage());
		}
		return registru;
	}

	/*REGISTRUL DE MORMINTE în care se înscriu toate locurile de morminte din cimitir. În acest
	registru se va arăta – cimitirul – parcela – numărul mormântului, numele, prenumele şi domiciliul
	deţinătorului, nr. chitanţei cu care s-a făcut plata locului de mormânt, numele, prenumele celor
	înmormântaţi, data înmormântării, suprafaţa locului şi o coloană pentru observaţii, în care se va
	arăta existenţa/inexistenţa construcţiilor funerare şi numărul actului în baza căruia s-au făcut
	modificări privind schimbarea deţinătorului, fotografia scanată a locului de veci.
	 */
	@Override
	public List<InregRegDeMorminte> getByParcelaAndNrLoc(String parcela,int nrLocDeVeci) throws SQLException {
		List<InregRegDeMorminte> registru = null;
		try{
			//toate locurile de veci
			String sqlSelect = "SELECT idLoc, c.denumire, p.denumire, numar, cc.cnpConcesionar1, cc.cnpConcesionar2, suprafata from LocuriDeVeci "
					+"INNER JOIN Parcele p ON LocuriDeVeci.idParcela= p.idParcela "
					+"INNER JOIN Cimitire c ON p.idCimitir= c.idCimitir "
					+"LEFT JOIN ContracteConcesiune cc on nrContractConcesiune = cc.nrContract where LocuriDeVeci.deleted=false AND Parcele.denumire = "+parcela+" AND LocDeVeci.numar=" +String.valueOf(nrLocDeVeci);
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegDeMorminte>();
			while(rs.next())
			{
				InregRegDeMorminte inregistrare = new InregRegDeMorminte();
				inregistrare.setNumarMormant(rs.getInt(4));
				inregistrare.setCimitir(rs.getString(2));
				inregistrare.setParcela(rs.getString(3));
				inregistrare.setSuprafata(rs.getInt(7));
				//concesionari pentru mormant
				String sqlSelectDetinatori = "SELECT dp.nume, dp.prenume, c.domiciliu, c.nrChitanta from Concesionari c "
						+"INNER JOIN DatePersonale dp on c.cnpConcesionar = dp.cnp where dp.cnp in ('"
						+rs.getString(5)+"','"+rs.getString(6)+"')";
				PreparedStatement psConcesionar = con.prepareStatement(sqlSelectDetinatori);
				ResultSet rsDateConcesionari = psConcesionar.executeQuery();
				String numePrenume="";
				String domicilii="";
				String nrChitante="";
				if(rsDateConcesionari.next())
				{
					numePrenume+=rsDateConcesionari.getString(1) +" " + rsDateConcesionari.getString(2) + "<br>";
					domicilii+=rsDateConcesionari.getString(3)+"<br>";
					nrChitante+=rsDateConcesionari.getInt(4)+"<br>";
					if(rsDateConcesionari.next())
					{
						numePrenume+=rsDateConcesionari.getString(1) +" " + rsDateConcesionari.getString(2);
						domicilii+=rsDateConcesionari.getString(3);
						nrChitante+=rsDateConcesionari.getInt(4)+"<br>";
					}
				
				}
				else
				{
					numePrenume="-";
					domicilii="-";
					nrChitante="-";
				}
				inregistrare.setNumePrenumeDetinatori(numePrenume);
				inregistrare.setDomiciliuDetinatori(domicilii);
				inregistrare.setNumereChitante(nrChitante);
				//decedati pentru mormant
				String sqlAllDecedati = "SELECT dp.nume, dp.prenume, d.dataInmormantare from Decedati d "
						+"INNER JOIN DatePersonale dp ON d.cnpDecedat=dp.cnp WHERE d.idLocDeVeci="+rs.getInt(1)
						+" UNION "
						+"SELECT dp.nume, dp.prenume, d.dataInmormantare from DecedatiFaraApartinatori d "
						+"INNER JOIN DatePersonale dp ON d.cnpDecedat=dp.cnp WHERE d.idLocDeVeci="+rs.getInt(1);
				PreparedStatement psDecedati = con.prepareStatement(sqlAllDecedati);
				ResultSet rsDecedati = psDecedati.executeQuery();
				String numePrenumeDecedati="",dateInmormantari="";
				int i=1;
				while(rsDecedati.next())
				{
					numePrenumeDecedati+=rsDecedati.getString(1)+" " +rsDecedati.getString(2)+"<br>";
					dateInmormantari+=rsDecedati.getDate(3).toString()+"<br>";
					i++;
				}
				if(numePrenumeDecedati=="" || dateInmormantari=="")
				{
					numePrenumeDecedati="-";
					dateInmormantari="-";
				}
				inregistrare.setNumePrenumeInmormantati(numePrenumeDecedati);
				inregistrare.setDateInmormantare(dateInmormantari);
				registru.add(inregistrare);
			}
		} catch (SQLException ex){
			throw new SQLException("Exceptie Accesare Date Registru: " + ex.getMessage());
		}
		return registru;
	}
   
	/* REGISTRUL DE MORMINTE-MONUMENTE FUNERARE cu valoare istorică, arhitecturală
 	sau monumentală şi ale eroilor şi personalităţilor istorice, politice, culturale sau cu alte merite
	deosebite, de importanţă naţională sau locală în care se va arăta parcela, numărul locului de 
	înhumare, numele, prenumele şi domiciliul concesionarului locului de înhumare, numărul chitanţei
	cu care s-a făcut plata concesiunii locului de înhumare, numele, prenumele celui înhumat, data
	înhumării, suprafaţa locului şi o coloană pentru observaţii, în care se va arăta existenţa/inexistenţa
	construcţiilor funerare şi numărul actului în baza căruia s-au făcut modificări privind schimbarea
	concesionarului, fotografia scanată a locului/monumentului.*/
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

	/* REGISTRUL INDEX ANUAL AL DECEDAŢILOR în care se înscriu în ordine alfabetică şi
    cronologică, toţi morţii trecuţi în registrul morţilor, având următoarele coloane: numele şi
    prenumele decedatului, cimitirul, parcela şi numărul mormântului în care a fost înmormântat.*/
	@Override
	public List<InregRegAnualDecedati> getRegAnualDecedati() throws SQLException {
		List<InregRegAnualDecedati> registru = null;
		try{
			String sqlSelect = "select dp.nume, dp.prenume, l.numar, p.denumire, c.denumire, d.dataInmormantare"
					+ "         from Decedati d"
					+ "         INNER JOIN DatePersonale dp"
					+ "         ON d.cnpDecedat = dp.cnp"
					+ "         INNER JOIN LocuriDeVeci l"
					+ "         ON d.idLocDeVeci = l.idLoc"
					+ "         INNER JOIN Parcele p"
					+ "         ON l.idParcela = p.idParcela"
					+ "         INNER JOIN Cimitire"
					+ "         c ON l.idCimitir = c.idCimitir"
					+ "         ORDER BY dp.nume, dp.prenume, d.dataInmormantare ";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegAnualDecedati>();
			while(rs.next())
			{
				InregRegAnualDecedati inregistrare = new InregRegAnualDecedati();
				inregistrare.setNume(rs.getString(1));
				inregistrare.setPrenume(rs.getString(2));
				inregistrare.setNrMormant(new Integer(rs.getInt(3)).toString());
				inregistrare.setParcela(rs.getString(4));
				inregistrare.setCimitir(rs.getString(5));
				inregistrare.setDataInmormantare(rs.getDate(6));
				registru.add(inregistrare);
			}
		} catch (SQLException ex){
			throw new SQLException("Exceptie Accesare Date Registru: " + ex.getMessage());
		}
		return registru;
	}

	/*REGISTRUL ANUAL DE EVIDENŢĂ A DECEDAŢILOR FĂRĂ APARŢINĂTORI – având
      următoarele coloane: adeverinţa de înhumare, solicitarea din partea IML/Asistenţă socială şi harta
      amplasării locurilor de înhumare.*/
	@Override
	public List<InregRegDecedatiFaraApartinatori> getRegAnualDecedatiFaraApartinatori()
			throws SQLException {
		List<InregRegDecedatiFaraApartinatori> registru = null;
		try{
			String sqlSelect = "SELECT dp.nume, dp.prenume, c.denumire, p.denumire, l.numar, d.dataInmormantare,"+
							"d.nrAdeverintaInhumare, d.nrAdeverintaAsistenta "+
							"FROM DecedatiFaraApartinatori d INNER JOIN DatePersonale dp ON d.cnpDecedat=dp.cnp "+
							"INNER JOIN LocuriDeVeci l ON d.idLocDeVeci = l.idLoc "+
							"INNER JOIN Parcele p ON l.idParcela = p.idParcela "+
							"INNER JOIN Cimitire c ON p.idCimitir = c.idCimitir";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegDecedatiFaraApartinatori>();
			while(rs.next())
			{
				InregRegDecedatiFaraApartinatori inregistrare = new InregRegDecedatiFaraApartinatori();
				inregistrare.setNume(rs.getString(1));
				inregistrare.setPrenume(rs.getString(2));
				inregistrare.setCimitir(rs.getString(3));
				inregistrare.setParcela(rs.getString(4));
				inregistrare.setNrMormant(String.valueOf(rs.getInt(5)));
				inregistrare.setDataInmormantare(rs.getDate(6));
				inregistrare.setNrAdeverintaInhumare(rs.getInt(7));
				inregistrare.setNrAdeverintaAsistenta(rs.getInt(8));
				registru.add(inregistrare);
			}
		} catch (SQLException ex){
			throw new SQLException("Exceptie Accesare Date Registru: " + ex.getMessage());
		}
		return registru;
	}

	/*REGISTRUL CU EVIDENŢA CERERILOR DE ATRIBUIRE A LOCURILOR DE
    ÎNHUMARE, având următoarele coloane: număr curent, data înregistrării, nr. infocet, stadiu de soluţionare*/
	@Override
	public List<InregRegCereriInhumare> getRegCereriInhumare()
			throws SQLException {
		List<InregRegCereriInhumare> registru = null;
		try{
			String sqlSelect = "SELECT nrCerere, dataInregistrare, stadiuSolutionare FROM CereriInhumare";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pSelect = con.prepareStatement(sqlSelect);
			ResultSet rs = pSelect.executeQuery();
			registru = new ArrayList<InregRegCereriInhumare>();
			while(rs.next())
			{
				InregRegCereriInhumare inregistrare = new InregRegCereriInhumare();
				inregistrare.setNrCerere(rs.getInt(1));
				inregistrare.setDataInregistrare(rs.getDate(2));
				inregistrare.setStadiuSolutionare(rs.getString(3));
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
