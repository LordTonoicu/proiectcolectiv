package domain.registers;

public class InregRegDeMorminte {
	
	private String cimitir;
	private String parcela;
	private Integer numarMormant;
    private String numeDetinator;
    private String prenumeDetinator;
    private String domiciliuDetinator;
    private Integer numarChitanta;
    private String numeInmormantat;
    private String prenumeInmormantat;
    private Float suprafata;
    private Boolean constructiiFunerare;
    private Integer nrActSchimbareDetinator;
    //fotografia scanata a locului de veci - path?
    
    
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
	public String getNumeDetinator() {
		return numeDetinator;
	}
	public void setNumeDetinator(String numeDetinator) {
		this.numeDetinator = numeDetinator;
	}
	public String getPrenumeDetinator() {
		return prenumeDetinator;
	}
	public void setPrenumeDetinator(String prenumeDetinator) {
		this.prenumeDetinator = prenumeDetinator;
	}
	public String getDomiciliuDetinator() {
		return domiciliuDetinator;
	}
	public void setDomiciliuDetinator(String domiciliuDetinator) {
		this.domiciliuDetinator = domiciliuDetinator;
	}
	public Integer getNumarChitanta() {
		return numarChitanta;
	}
	public void setNumarChitanta(Integer numarChitanta) {
		this.numarChitanta = numarChitanta;
	}
	public String getNumeInmormantat() {
		return numeInmormantat;
	}
	public void setNumeInmormantat(String numeInmormantat) {
		this.numeInmormantat = numeInmormantat;
	}
	public String getPrenumeInmormantat() {
		return prenumeInmormantat;
	}
	public void setPrenumeInmormantat(String prenumeInmormantat) {
		this.prenumeInmormantat = prenumeInmormantat;
	}
	public Float getSuprafata() {
		return suprafata;
	}
	public void setSuprafata(Float suprafata) {
		this.suprafata = suprafata;
	}
	public Boolean getConstructiiFunerare() {
		return constructiiFunerare;
	}
	public void setConstructiiFunerare(Boolean constructiiFunerare) {
		this.constructiiFunerare = constructiiFunerare;
	}
	public Integer getNrActSchimbareDetinator() {
		return nrActSchimbareDetinator;
	}
	public void setNrActSchimbareDetinator(Integer nrActSchimbareDetinator) {
		this.nrActSchimbareDetinator = nrActSchimbareDetinator;
	}
	public InregRegDeMorminte(String cimitir, String parcela,
			Integer numarMormant, String numeDetinator,
			String prenumeDetinator, String domiciliuDetinator,
			Integer numarChitanta, String numeInmormantat,
			String prenumeInmormantat, Float suprafata,
			Boolean constructiiFunerare, Integer nrActSchimbareDetinator) {
		super();
		this.cimitir = cimitir;
		this.parcela = parcela;
		this.numarMormant = numarMormant;
		this.numeDetinator = numeDetinator;
		this.prenumeDetinator = prenumeDetinator;
		this.domiciliuDetinator = domiciliuDetinator;
		this.numarChitanta = numarChitanta;
		this.numeInmormantat = numeInmormantat;
		this.prenumeInmormantat = prenumeInmormantat;
		this.suprafata = suprafata;
		this.constructiiFunerare = constructiiFunerare;
		this.nrActSchimbareDetinator = nrActSchimbareDetinator;
	}

	public InregRegDeMorminte() {
		super();
	}

}
