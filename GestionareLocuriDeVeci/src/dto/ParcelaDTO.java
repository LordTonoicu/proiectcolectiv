package dto;

import domain.Parcela;

public class ParcelaDTO {
	
	private Parcela parcela;
	private String denumireCimitir;
	
	public ParcelaDTO() {
		super();
	}
	public ParcelaDTO(Parcela parcela, String denumireCimitir) {
		super();
		this.parcela = parcela;
		this.denumireCimitir = denumireCimitir;
	}
	public Parcela getParcela() {
		return parcela;
	}
	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}
	public String getDenumireCimitir() {
		return denumireCimitir;
	}
	public void setDenumireCimitir(String denumireCimitir) {
		this.denumireCimitir = denumireCimitir;
	}
}
