package domain;

public class DatePersonale {

	private String cnp;
	private String nume;
	private String prenume;

	public DatePersonale() {

	}

	public DatePersonale(String cnp, String nume, String prenume) {

		this.cnp = cnp;
		this.nume = nume;
		this.prenume = prenume;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	@Override
	public String toString() {
		return "DatePersonale [cnp=" + cnp + ", nume=" + nume + ", prenume="
				+ prenume + "]";
	}
}
