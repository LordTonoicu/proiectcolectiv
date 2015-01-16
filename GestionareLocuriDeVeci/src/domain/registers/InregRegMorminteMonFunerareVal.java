package domain.registers;

import java.sql.Date;

public class InregRegMorminteMonFunerareVal {

	private String cimitir;
	private String parcela;
	private Integer numarLoc;
	private Integer suprafata;
	private String numePrenumeConcesionar;
	private String domiciliuConcesionar;
	private String numarChitanta;
	private String numePrenumeInhumat;
	private String dataInhumarii;
	
	public InregRegMorminteMonFunerareVal() {
		super();
	}

	public InregRegMorminteMonFunerareVal(String cimitir, String parcela,
			Integer numarLoc, Integer suprafata, String numePrenumeConcesionar,
			String domiciliuConcesionar, String numarChitanta,
			String numePrenumeInhumat, String dataInhumarii) {
		super();
		this.cimitir = cimitir;
		this.parcela = parcela;
		this.numarLoc = numarLoc;
		this.suprafata = suprafata;
		this.numePrenumeConcesionar = numePrenumeConcesionar;
		this.domiciliuConcesionar = domiciliuConcesionar;
		this.numarChitanta = numarChitanta;
		this.numePrenumeInhumat = numePrenumeInhumat;
		this.dataInhumarii = dataInhumarii;
	}


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

	public Integer getNumarLoc() {
		return numarLoc;
	}

	public void setNumarLoc(Integer numarLoc) {
		this.numarLoc = numarLoc;
	}

	public String getNumePrenumeConcesionar() {
		return numePrenumeConcesionar;
	}

	public void setNumePrenumeConcesionar(String numeprenumeConcesionar) {
		this.numePrenumeConcesionar = numeprenumeConcesionar;
	}

	public String getDomiciliuConcesionar() {
		return domiciliuConcesionar;
	}

	public void setDomiciliuConcesionar(String domiciliuConcesionar) {
		this.domiciliuConcesionar = domiciliuConcesionar;
	}

	public String getNumarChitanta() {
		return numarChitanta;
	}

	public void setNumarChitanta(String numarChitanta) {
		this.numarChitanta = numarChitanta;
	}

	public String getNumePrenumeInhumat() {
		return numePrenumeInhumat;
	}

	public void setNumePrenumeInhumat(String numeInhumat) {
		this.numePrenumeInhumat = numeInhumat;
	}

	public String getDataInhumarii() {
		return dataInhumarii;
	}

	public void setDataInhumarii(String dataInhumarii) {
		this.dataInhumarii = dataInhumarii;
	}

	public Integer getSuprafata() {
		return suprafata;
	}

	public void setSuprafata(Integer suprafata) {
		this.suprafata = suprafata;
	}


}
