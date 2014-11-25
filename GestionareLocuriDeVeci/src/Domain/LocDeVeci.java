package Domain;

import java.sql.Blob;

public class LocDeVeci {

	private int idLoc;
	private int suprafata;
	private int idParcela;
	private int numar;
	private Blob poza;
	private boolean isMonument;
	private int idCimitir;

	public LocDeVeci() {

	}

	public LocDeVeci(int idLoc, int suprafata, int idParcela, int numar,
			Blob poza, boolean isMonument, int idCimitir) {

		this.idLoc = idLoc;
		this.suprafata = suprafata;
		this.idParcela = idParcela;
		this.numar = numar;
		this.poza = poza;
		this.isMonument = isMonument;
		this.idCimitir = idCimitir;
	}

	public int getIdLoc() {
		return idLoc;
	}

	public void setIdLoc(int idLoc) {
		this.idLoc = idLoc;
	}

	public int getSuprafata() {
		return suprafata;
	}

	public void setSuprafata(int suprafata) {
		this.suprafata = suprafata;
	}

	public int getIdParcela() {
		return idParcela;
	}

	public void setIdParcela(int idParcela) {
		this.idParcela = idParcela;
	}

	public int getNumar() {
		return numar;
	}

	public void setNumar(int numar) {
		this.numar = numar;
	}

	public Blob getPoza() {
		return poza;
	}

	public void setPoza(Blob poza) {
		this.poza = poza;
	}

	public boolean isMonument() {
		return isMonument;
	}

	public void setMonument(boolean isMonument) {
		this.isMonument = isMonument;
	}

	public int getIdCimitir() {
		return idCimitir;
	}

	public void setIdCimitir(int idCimitir) {
		this.idCimitir = idCimitir;
	}

	@Override
	public String toString() {
		return "LocDeVeci [idLoc=" + idLoc + ", suprafata=" + suprafata
				+ ", idParcela=" + idParcela + ", numar=" + numar + ", poza="
				+ poza + ", isMonument=" + isMonument + ", idCimitir="
				+ idCimitir + "]";
	}
}
