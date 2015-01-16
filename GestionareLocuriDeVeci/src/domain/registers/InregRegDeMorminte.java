package domain.registers;

public class InregRegDeMorminte {
	
	private String cimitir;
	private String parcela;
	private Integer numarMormant;
	private int suprafata;
    private String numePrenumeDetinatori;
    private String domiciliuDetinatori;
    private String numereChitante;
    private String numePrenumeInmormantati;
    private String dateInmormantare;
 

	public String getCimitir() {
		return cimitir;
	}


	public void setCimitir(String cimitir) {
		this.cimitir = cimitir;
	}


	public String getParcela() {
		return parcela;
	}


	public void setParcela(String parcela) {
		this.parcela = parcela;
	}


	public Integer getNumarMormant() {
		return numarMormant;
	}


	public void setNumarMormant(Integer numarMormant) {
		this.numarMormant = numarMormant;
	}


	public int getSuprafata() {
		return suprafata;
	}


	public void setSuprafata(int suprafata) {
		this.suprafata = suprafata;
	}


	public String getNumePrenumeDetinatori() {
		return numePrenumeDetinatori;
	}


	public void setNumePrenumeDetinatori(String numePrenumeDetinatori) {
		this.numePrenumeDetinatori = numePrenumeDetinatori;
	}


	public String getDomiciliuDetinatori() {
		return domiciliuDetinatori;
	}


	public void setDomiciliuDetinatori(String domiciliuDetinatori) {
		this.domiciliuDetinatori = domiciliuDetinatori;
	}


	public String getNumereChitante() {
		return numereChitante;
	}


	public void setNumereChitante(String numereChitante) {
		this.numereChitante = numereChitante;
	}


	public String getNumePrenumeInmormantati() {
		return numePrenumeInmormantati;
	}


	public void setNumePrenumeInmormantati(String numePrenumeInmormantati) {
		this.numePrenumeInmormantati = numePrenumeInmormantati;
	}


	public String getDateInmormantare() {
		return dateInmormantare;
	}


	public void setDateInmormantare(String dateInmormantare) {
		this.dateInmormantare = dateInmormantare;
	}


	public InregRegDeMorminte(String cimitir, String parcela,
			Integer numarMormant, int suprafata, String numePrenumeDetinatori,
			String domiciliuDetinatori, String numereChitante,
			String numePrenumeInmormantati, String dateInmormantare) {
		super();
		this.cimitir = cimitir;
		this.parcela = parcela;
		this.numarMormant = numarMormant;
		this.suprafata = suprafata;
		this.numePrenumeDetinatori = numePrenumeDetinatori;
		this.domiciliuDetinatori = domiciliuDetinatori;
		this.numereChitante = numereChitante;
		this.numePrenumeInmormantati = numePrenumeInmormantati;
		this.dateInmormantare = dateInmormantare;
	}


	public InregRegDeMorminte() {
		super();
	}

}
