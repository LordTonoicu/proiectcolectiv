package dto;
import domain.ContractConcesiune;


public class ContractConcesiuneDTO {
	 private ConcesionarDTO concesionar2;
	 private ConcesionarDTO concesionar1;
	 private ContractConcesiune contractConcesiune;

	    public ContractConcesiuneDTO() {
			super();
		}
		public ContractConcesiuneDTO(ConcesionarDTO concesionar2,ConcesionarDTO concesionar1,ContractConcesiune contractConcesiune) {
			super();
			this.concesionar1 = concesionar1;
			this.concesionar2 = concesionar2;
		}
		
		public ConcesionarDTO getConcesionar2() {
			return concesionar2;
		}
		public void setConcesionar2(ConcesionarDTO concesionar2) {
			this.concesionar2 = concesionar2;
		}
		public ConcesionarDTO getConcesionar1() {
			return concesionar1;
		}
		public void setConcesionar1(ConcesionarDTO concesionar1) {
			this.concesionar1 = concesionar1;
		}
		public ContractConcesiune getContractConcesiune() {
			return contractConcesiune;
		}
		public void setContractConcesiune(ContractConcesiune contractConcesiune) {
			this.contractConcesiune = contractConcesiune;
		}
		@Override
		public String toString(){
			return concesionar1.toString()+" "+concesionar2.toString() + " " + contractConcesiune.toString();
		}

}
