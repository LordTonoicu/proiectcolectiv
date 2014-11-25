package Domain;

import java.util.Date;

public class ContractConcesiune {

	private int nrContract;
	private Date dataEliberare;
	private String cnpConcesionar1;
	private String cnpConcesionar2;

	public ContractConcesiune() {

	}

	public ContractConcesiune(int nrContract, Date dataEliberare,
			String cnpConcesionar1, String cnpConcesionar2) {

		this.nrContract = nrContract;
		this.dataEliberare = dataEliberare;
		this.cnpConcesionar1 = cnpConcesionar1;
		this.cnpConcesionar2 = cnpConcesionar2;
	}

	public int getNrContract() {
		return nrContract;
	}

	public void setNrContract(int nrContract) {
		this.nrContract = nrContract;
	}

	public Date getDataEliberare() {
		return dataEliberare;
	}

	public void setDataEliberare(Date dataEliberare) {
		this.dataEliberare = dataEliberare;
	}

	public String getCnpConcesionar1() {
		return cnpConcesionar1;
	}

	public void setCnpConcesionar1(String cnpConcesionar1) {
		this.cnpConcesionar1 = cnpConcesionar1;
	}

	public String getCnpConcesionar2() {
		return cnpConcesionar2;
	}

	public void setCnpConcesionar2(String cnpConcesionar2) {
		this.cnpConcesionar2 = cnpConcesionar2;
	}

	@Override
	public String toString() {
		return "ContractConcesiune [nrContract=" + nrContract
				+ ", dataEliberare=" + dataEliberare + ", cnpConcesionar1="
				+ cnpConcesionar1 + ", cnpConcesionar2=" + cnpConcesionar2
				+ "]";
	}
}
