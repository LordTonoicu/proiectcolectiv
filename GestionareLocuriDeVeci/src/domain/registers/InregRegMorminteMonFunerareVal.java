package domain.registers;

import java.sql.Date;

public class InregRegMorminteMonFunerareVal {
	
	private String parcela;
	private Integer numarLoc;
	private String prenumeConcesionar;
	private String domiciliuDetinator;
	private String domiciliuConcesionar;
	private Integer numarChitanta;
	private String numeInhumat;
	private String prenumeInhumat;
	private Date dataInhumarii;
	private Boolean constructiiFunerare;
	private Integer nrActSchimbareConcesionar;
	//fotografia scanata a locului de veci - path?
	
	
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}
	public Integer getNumarLoc() {
		return numarLoc;
	}
	public void setNumarLoc(Integer numarLoc) {
		this.numarLoc = numarLoc;
	}
	public String getPrenumeConcesionar() {
		return prenumeConcesionar;
	}
	public void setPrenumeConcesionar(String prenumeConcesionar) {
		this.prenumeConcesionar = prenumeConcesionar;
	}
	public String getDomiciliuDetinator() {
		return domiciliuDetinator;
	}
	public void setDomiciliuDetinator(String domiciliuDetinator) {
		this.domiciliuDetinator = domiciliuDetinator;
	}
	public String getDomiciliuConcesionar() {
		return domiciliuConcesionar;
	}
	public void setDomiciliuConcesionar(String domiciliuConcesionar) {
		this.domiciliuConcesionar = domiciliuConcesionar;
	}
	public Integer getNumarChitanta() {
		return numarChitanta;
	}
	public void setNumarChitanta(Integer numarChitanta) {
		this.numarChitanta = numarChitanta;
	}
	public String getNumeInhumat() {
		return numeInhumat;
	}
	public void setNumeInhumat(String numeInhumat) {
		this.numeInhumat = numeInhumat;
	}
	public String getPrenumeInhumat() {
		return prenumeInhumat;
	}
	public void setPrenumeInhumat(String prenumeInhumat) {
		this.prenumeInhumat = prenumeInhumat;
	}
	public Date getDataInhumarii() {
		return dataInhumarii;
	}
	public void setDataInhumarii(Date dataInhumarii) {
		this.dataInhumarii = dataInhumarii;
	}
	public Boolean getConstructiiFunerare() {
		return constructiiFunerare;
	}
	public void setConstructiiFunerare(Boolean constructiiFunerare) {
		this.constructiiFunerare = constructiiFunerare;
	}
	public Integer getNrActSchimbareConcesionar() {
		return nrActSchimbareConcesionar;
	}
	public void setNrActSchimbareConcesionar(Integer nrActSchimbareConcesionar) {
		this.nrActSchimbareConcesionar = nrActSchimbareConcesionar;
	}
	public InregRegMorminteMonFunerareVal(String parcela, Integer numarLoc,
			String prenumeConcesionar, String domiciliuDetinator,
			String domiciliuConcesionar, Integer numarChitanta,
			String numeInhumat, String prenumeInhumat, Date dataInhumarii,
			Boolean constructiiFunerare, Integer nrActSchimbareConcesionar) {
		super();
		this.parcela = parcela;
		this.numarLoc = numarLoc;
		this.prenumeConcesionar = prenumeConcesionar;
		this.domiciliuDetinator = domiciliuDetinator;
		this.domiciliuConcesionar = domiciliuConcesionar;
		this.numarChitanta = numarChitanta;
		this.numeInhumat = numeInhumat;
		this.prenumeInhumat = prenumeInhumat;
		this.dataInhumarii = dataInhumarii;
		this.constructiiFunerare = constructiiFunerare;
		this.nrActSchimbareConcesionar = nrActSchimbareConcesionar;
	}
	public InregRegMorminteMonFunerareVal() {
		super();
	}
	
}
