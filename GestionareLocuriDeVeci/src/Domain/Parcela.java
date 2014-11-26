package Domain;

public class Parcela {

	private int idParcela;
	private String denumire;
	private int nrLocuri;
	private int idCimitir;
	private boolean hasMonument;

	public Parcela() {

	}

	public Parcela(String denumire, int nrLocuri, int idCimitir,
			boolean hasMonument) {

		this.denumire = denumire;
		this.nrLocuri = nrLocuri;
		this.idCimitir = idCimitir;
		this.hasMonument = hasMonument;
	}
	
	public Parcela(int idParcela, String denumire, int nrLocuri, int idCimitir,
			boolean hasMonument) {

		this.idParcela = idParcela;
		this.denumire = denumire;
		this.nrLocuri = nrLocuri;
		this.idCimitir = idCimitir;
		this.hasMonument = hasMonument;
	}

	public int getIdParcela() {
		return idParcela;
	}

	public void setIdParcela(int idParcela) {
		this.idParcela = idParcela;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public int getNrLocuri() {
		return nrLocuri;
	}

	public void setNrLocuri(int nrLocuri) {
		this.nrLocuri = nrLocuri;
	}

	public int getIdCimitir() {
		return idCimitir;
	}

	public void setIdCimitir(int idCimitir) {
		this.idCimitir = idCimitir;
	}

	public boolean isHasMonument() {
		return hasMonument;
	}

	public void setHasMonument(boolean hasMonument) {
		this.hasMonument = hasMonument;
	}

	@Override
	public String toString() {
		return "Parcela [idParcela=" + idParcela + ", denumire=" + denumire
				+ ", nrLocuri=" + nrLocuri + ", idCimitir=" + idCimitir
				+ ", hasMonument=" + hasMonument + "]";
	}
}
