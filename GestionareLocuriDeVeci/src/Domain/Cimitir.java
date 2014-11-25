package Domain;

public class Cimitir {

	private int idCimitir;
	private String denumire;
	private String adresa;
	private int nrLocuri;
	private int nrParcele;

	public Cimitir() {

	}

	public Cimitir(int idCimitir, String denumire, String adresa, int nrLocuri,
			int nrParcele) {

		this.idCimitir = idCimitir;
		this.denumire = denumire;
		this.adresa = adresa;
		this.nrLocuri = nrLocuri;
		this.nrParcele = nrParcele;
	}

	public int getIdCimitir() {
		return idCimitir;
	}

	public void setIdCimitir(int idCimitir) {
		this.idCimitir = idCimitir;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getNrLocuri() {
		return nrLocuri;
	}

	public void setNrLocuri(int nrLocuri) {
		this.nrLocuri = nrLocuri;
	}

	public int getNrParcele() {
		return nrParcele;
	}

	public void setNrParcele(int nrParcele) {
		this.nrParcele = nrParcele;
	}

	@Override
	public String toString() {
		return "Cimitir [idCimitir=" + idCimitir + ", denumire=" + denumire
				+ ", adresa=" + adresa + ", nrLocuri=" + nrLocuri
				+ ", nrParcele=" + nrParcele + "]";
	}
}
